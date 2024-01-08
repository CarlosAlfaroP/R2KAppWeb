package com.example.r2kappweb.backend

// llave no incluida en GIT, añadir a .gitignore
import com.example.r2kappweb.llave
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.kvision.modal.Alert
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
    //Comprueba que el usuario exista en la BD, si no existe lo crea
    if (consulta!=null && consulta!="") {
        Alert.show(
            "Registro",
            "El usuario ${usuario.nombre_usuario} ya existe",
            centered = true
        )
    } else {
        val objetoDB = usuario.copy(tipo_usuario = usuario.tipo_usuario ?: "tutor")
        supabaseClient.from("usuarios").insert(objetoDB)
        Alert.show(
            "Registro",
            "El usuario ${usuario.nombre_usuario} creado",
            centered = true
        )
    }
}
suspend fun registrarAlumno(datosAlumno:  Map<String, Any?>, nombreUsuario: String) {
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
    // Extraer los valores del Map y convertirlos a los tipos correctos
    val nombre = datosAlumno["nombre"] as? String ?: ""
    val nombreUsuarioAlumno = datosAlumno["nombre_usuario"] as? String ?: ""
    val password = datosAlumno["password"] as? String ?: ""
    val correo = datosAlumno["correo"] as? String
    val fechaNacimientoJS = datosAlumno["edad"] as? Date
    val fechaNacimiento = fechaNacimientoJS?.let {
        "${it.getFullYear()}-${it.getMonth() + 1}-${it.getDate()}"
    }
    val usuarioDB = UsuarioDB(
        nombre = nombre,
        nombre_usuario = nombreUsuarioAlumno,
        edad = fechaNacimiento,
        password = password,
        correo = correo,
        tipo_usuario = "alumno",
        id_tutor = idTutor
    )
    supabaseClient.from("usuarios").insert(usuarioDB)
}
suspend fun consultaUsuario (usuario: UsuarioDB, cliente:SupabaseClient) : String? {
    val username = cliente.from("usuarios")
        .select(columns = Columns.list("nombre_usuario")) {
            filter {
                eq( "nombre_usuario", usuario.nombre_usuario)
            }
        }
        .decodeSingleOrNull<RespuestaUsername>()
    val nombre = username?.nombre_usuario
    return nombre
}
suspend fun consultaTutor (usuario: String) : Boolean {
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
    val supabaseClient = createSupabaseClient(
        supabaseUrl = llave.SUPABASE_URL,
        supabaseKey = llave.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }
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
    return objeto
}

suspend fun actualizarPerfil(usuarioActualizado: UsuarioDB): UsuarioDB? {
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
        .select(columns = Columns.list("nombre", "nombre_usuario", "edad", "password", "correo", "tipo_usuario")) {
            filter {
                eq( "id_tutor", idUsuario)
            }
        }
        .decodeList<UsuarioDB>()
    return listaObjetos
}

fun validarEdad(fechaNacimiento: Date?): Boolean {
    fechaNacimiento ?: return false

    val fechaActual = Date()
    val diferenciaAnios = fechaActual.getFullYear() - fechaNacimiento.getFullYear()

    // Crear una nueva fecha para el cumpleaños de este año
    val cumpleanosEsteAnio = Date(fechaActual.getFullYear(), fechaNacimiento.getMonth(), fechaNacimiento.getDate())

    // Compara las fechas en milisegundos
    return if (diferenciaAnios > 18) {
        true
    } else if (diferenciaAnios == 18) {
        cumpleanosEsteAnio.getTime() <= fechaActual.getTime()
    } else {
        false
    }
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