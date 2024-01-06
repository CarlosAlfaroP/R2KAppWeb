package com.example.r2kappweb.backend

// llave no incluida en GIT, añadir a .gitignore
import com.example.r2kappweb.llave
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlin.js.Date

suspend fun loginUsuario (usuario: String, contraseña: String): Boolean {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }

    val respuesta = supabaseClient.from("usuarios")
        .select(columns = Columns.list("nombre_usuario", "nombre", "password")) {
            filter {
                eq("nombre_usuario", usuario)
            }
        }
        .decodeSingle<RespuestaUsuario>()
    return if (respuesta != null) {
        respuesta.password == contraseña
    } else {
        false
    }
}

suspend fun registerUsuario (usuario: UsuarioDB) {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    val consulta = consultaUsuario(usuario,supabaseClient)
    println("consulta es $consulta")
    println("end consulta")
    //Comprueba que el usuario exista en la BD, si no existe lo crea
    if (consulta!=null && consulta!="") {
        println("if consulta no es null")
        println("El usuario $consulta ya existe")
    } else {
        println("if es null consulta else")
        println("${usuario.nombre_usuario} se creará")
        println("Usuario completo es $usuario")
        println("Creando objetoDB")
        val objetoDB = usuario.copy(tipo_usuario = usuario.tipo_usuario ?: "tutor")
            //UsuarioDB (nombre_usuario = usuario.nombre_usuario, nombre = usuario.nombre, correo = usuario.correo, edad = usuario.edad, password = usuario.password, tipo_usuario = "tutor")
        print("El objeto a crear es $objetoDB")
        supabaseClient.from("usuarios").insert(objetoDB)
    }
}

suspend fun registrarAlumno(datosAlumno:  Map<String, Any?>, nombreUsuario: String) {
    println("Init Consulta Lista")
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }

    val consultaIdUsuario = supabaseClient.from("usuarios")
        .select(columns = Columns.list("id_usuario")) {
            filter {
                eq("nombre_usuario", nombreUsuario)
            }
        }
        .decodeSingleOrNull<RespuestaUsernameId>()
    val idTutor = consultaIdUsuario?.id_usuario
    println("El id del tutor es: $idTutor")

    // Extraer los valores del Map y convertirlos a los tipos correctos
    val nombre = datosAlumno["nombre"] as? String ?: ""
    val nombreUsuarioAlumno = datosAlumno["nombre_usuario"] as? String ?: ""
    val password = datosAlumno["password"] as? String ?: ""
    val correo = datosAlumno["correo"] as? String
    val fechaNacimientoJS = datosAlumno["edad"] as? Date
    val fechaNacimiento = fechaNacimientoJS?.let {
        "${it.getFullYear()}-${it.getMonth() + 1}-${it.getDate()}"
    }
    println("El datosAlumno es: $datosAlumno")

    val usuarioDB = UsuarioDB(
        nombre = nombre,
        nombre_usuario = nombreUsuarioAlumno,
        edad = fechaNacimiento,
        password = password,
        correo = correo,
        tipo_usuario = "alumno",
        id_tutor = idTutor
    )
    println("El usuarioDB es: $usuarioDB")
    val resultado = supabaseClient.from("usuarios").insert(usuarioDB)
    println("Resultado de la inserción: $resultado")
}

suspend fun consultaUsuario (usuario: UsuarioDB, cliente:SupabaseClient) : String? {
    println("Inicia Consulta")
    println("Usuario es $usuario")
    val username = cliente.from("usuarios")
        .select(columns = Columns.list("nombre_usuario")) {
            filter {
                eq( "nombre_usuario", usuario.nombre_usuario)
            }
        }
        .decodeSingleOrNull<RespuestaUsername>()
    println("username $username")
    val nombre = username?.nombre_usuario
    println("nombre ${username?.nombre_usuario}")
    return nombre
}

suspend fun consultaTutor (usuario: String) : Boolean {
    println("Inicio ConsultaTutor")
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    val consulta = supabaseClient.from("usuarios")
        .select(columns = Columns.list("nombre_usuario","tipo_usuario")) {
            filter {
                eq( "nombre_usuario", usuario)
            }
        }
        .decodeSingleOrNull<RespuestaTutor>()
    val confirmacion = consulta?.tipo_usuario
    if (confirmacion=="tutor") {
        return true
    } else {
        return false
    }
}

suspend fun obtenerPerfil(username: String) : UsuarioDB {
    println("Init obtenerPerfil")
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    println("consulta es por $username")
    val objeto = supabaseClient.from("usuarios")
        .select(columns = Columns.list(
            "nombre",
            "nombre_usuario",
            "edad",
            "password",
            "correo",
            "tipo_usuario"
        )) {
            filter {
                eq( "nombre_usuario", username)
            }
        }
        .decodeSingle<UsuarioDB>()
    println("Creado este objeto $objeto")

    return objeto
}

suspend fun actualizarPerfil(usuarioActualizado: UsuarioDB): UsuarioDB? {
    println("Init actualizarPerfil")
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    return try {
        val resultado = supabaseClient.from("usuarios")
            .update(
                UsuarioDB(
                    nombre = usuarioActualizado.nombre,
                    edad = usuarioActualizado.edad,
                    password = usuarioActualizado.password,
                    correo = usuarioActualizado.correo,
                    nombre_usuario = usuarioActualizado.nombre_usuario,
                    tipo_usuario = "tutor",
                    id_tutor = null
                )
            ) {
                select()
                filter {
                    eq("nombre_usuario", usuarioActualizado.nombre_usuario)
                }
            }.decodeSingle<RespuestaUsuarioDBActualizado>()
        println("Resultado: $resultado")
        val resultadoUsuarioDB = UsuarioDB(
            nombre = resultado.nombre,
            nombre_usuario = resultado.nombre_usuario,
            edad = resultado.edad,
            password = resultado.password,
            correo = resultado.correo,
            tipo_usuario = resultado.tipo_usuario,
            id_tutor = resultado.id_tutor
        )
        return resultadoUsuarioDB
    } catch (e: Exception) {
        println("Error al actualizar el perfil: ${e.message}")
        null
    }
}

suspend fun actualizarAlumno(datosAlumno: UsuarioDB): Boolean {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    val respuestaIdTutor = supabaseClient.from("usuarios")
        .select(columns = Columns.list("id_tutor")) {
            filter {
                eq( "nombre_usuario", datosAlumno.nombre_usuario)
            }
        }.decodeSingle<RespuestaTutorId>()
    val idTutor = respuestaIdTutor.id_tutor
    val usuarioDB = datosAlumno
    usuarioDB.id_tutor = idTutor
    return try {
        val respuesta = supabaseClient.from("usuarios")
            .update(usuarioDB) {
                select()
                filter {
                    eq("nombre_usuario", datosAlumno.nombre_usuario)
                }
            }
        val resultado = respuesta.decodeSingleOrNull<UsuarioDB>()
        resultado != null
    } catch (e: Exception) {
        false
    }
}

suspend fun eliminarAlumno(nombreUsuarioAlumno: String): Boolean {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    return try {
        val resultado = supabaseClient.from("usuarios")
            .delete {
                filter {
                    eq("nombre_usuario", nombreUsuarioAlumno)
                }
            }
        true
    } catch (e: Exception) {
        false
    }
}


suspend fun consultaListaAlumnos(username:String) : List<UsuarioDB> {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
    val consultaIdUsuario = supabaseClient.from("usuarios")
        .select(columns = Columns.list("id_usuario")) {
            filter {
                eq("nombre_usuario", username)
            }
        }
        .decodeSingle<RespuestaUsernameId>()
    val idUsuario = consultaIdUsuario.id_usuario
    val listaObjetos = supabaseClient.from("usuarios")
        .select(columns = Columns.list("nombre", "nombre_usuario", "edad", "password", "correo", "tipo_usuario")) {{}
            filter {
                eq( "id_tutor", idUsuario)
            }
        }
        .decodeList<UsuarioDB>()
    return listaObjetos
}

@Serializable
data class RespuestaUsername (
    val nombre_usuario: String
)

@Serializable
data class RespuestaUsernameId (
    val id_usuario: Int
)

@Serializable
data class RespuestaTutorId (
    val id_tutor: Int
)

@Serializable
data class RespuestaTutor (
    val nombre_usuario: String,
    val tipo_usuario: String
)
@Serializable
data class RespuestaUsuario (
    val nombre_usuario: String,
    val nombre: String,
    val password: String
)

@Serializable
data class UsuarioDB(
    val nombre: String,
    val nombre_usuario: String,
    val edad: String?,
    val password: String,
    val correo: String?,
    val tipo_usuario: String,
    var id_tutor: Int? = null,
    val id_usuario: Int? = null
)

@Serializable
data class RespuestaUsuarioDBActualizado(
    val nombre: String,
    val nombre_usuario: String,
    val edad: String?,
    val password: String,
    val correo: String?,
    val tipo_usuario: String,
    val id_tutor: Int? = null,
    val id_usuario: Int?
)

@Serializable
data class NuevoAlumno(
    val nombre: String,
    val nombre_usuario: String,
    @Contextual val edad: Date?,
    val correo: String?,
    val password: String,
    val password2: String
)

@Serializable
data class AlumnoModel(
    val nombre: String,
    val nombre_usuario: String,
    @Contextual val edad: Date?,
    val correo: String?,
    val password: String,
    val password2: String
)