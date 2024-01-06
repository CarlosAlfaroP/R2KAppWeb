package com.example.r2kappweb.apps

import com.example.r2kappweb.backend.*
import com.example.r2kappweb.screens.UserModel
import io.kvision.core.*
import io.kvision.form.FormPanel
import io.kvision.form.select.Select
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.form.time.DateTime
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.label
import io.kvision.modal.Alert
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.table.*
import io.kvision.utils.px
import io.kvision.window.Window
import kotlinx.coroutines.*
import kotlin.js.Date

class PerfilApp(private val root: Container, private val usuario: String) : DesktopWindow("Perfil", "fa-solid fa-book-open", 500, 400) {
    private val perfilScope = CoroutineScope(Dispatchers.Main + Job())
    lateinit var selectAlumnos: Select
    init {
        height = 550.px
        perfilScope.launch {
            val perfilUsuario = obtenerPerfil(usuario)
            val consultaTutor  = consultaTutor(usuario)
            val formPanel = FormPanel<UserModel>()
            val listaUsuario = consultaListaAlumnos(usuario)
            if (consultaTutor) {
                this@PerfilApp.addTutorTabPanel(formPanel, perfilUsuario,listaUsuario)
            } else {
                this@PerfilApp.addTabPanel(formPanel, perfilUsuario)
            }
        }
    }

    private fun Container.addTutorTabPanel(formPanel: FormPanel<UserModel>, perfilUsuarioDB: UsuarioDB, listaUsuario: List<UsuarioDB>) {
        val fechaNacimiento = perfilUsuarioDB.edad?.replace("-", "/")
        val fechaDate = fechaNacimiento?.let { Date(it) }
        tabPanel(draggableTabs = true) {
            tab("Tutor") {
                with(formPanel) {
                    val emailField = Text(label = "Email", value = perfilUsuarioDB.correo)

                    add(UserModel::nombre, Text(label = "Nombre", value = perfilUsuarioDB.nombre), required = true, requiredMessage = "Nombre requerido")
                    add(UserModel::email, emailField, required = true, requiredMessage = "Email requerido", validator = {
                        val emailText = emailField.getValue()
                        if (!emailText.isNullOrEmpty()) {
                            val emailRegex = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
                            emailRegex.matches(emailText)
                        } else {
                            false
                        }
                    })
                    add(UserModel::password, Password(label = "Contraseña", floating = true), required = true, requiredMessage = "Contraseña requerida", validatorMessage = { "Contraseña muy corta" }) {(it.getValue()?.length ?: 0) >= 8}
                    add(UserModel::password2, Password(label = "Confirma tu contraseña", floating = true), required = true, requiredMessage = "Se debe confirmar la contraseña", validatorMessage = { "Contraseña muy corta" }) { (it.getValue()?.length ?: 0) >= 8}
                    add(UserModel::edad, DateTime(label = "Fecha de nacimiento", format = "YYYY-MM-DD", value = fechaDate), required = true, requiredMessage = "Fecha requerida")
                    div {
                        style {
                            margin = 20.px
                            display = Display.FLEX
                            justifyContent = JustifyContent.SPACEEVENLY
                        }
                        button("Actualizar Perfil", style = ButtonStyle.PRIMARY).onClickLaunch {
                            if (formPanel.validate()) {
                                val datosActualizados = formPanel.getData() as Map<String, Any?>
                                val edad = datosActualizados["edad"] as? Date
                                val edadFormat = edad?.let {
                                    "${it.getFullYear()}-${(it.getMonth() + 1).toString().padStart(2, '0')}-${it.getDate().toString().padStart(2, '0')}"
                                } ?: "Fecha no encontrada"

                                val usuarioDBActualizado = UsuarioDB(
                                    nombre = datosActualizados["nombre"] as? String ?: "",
                                    edad = edadFormat,
                                    password = datosActualizados["password"] as? String ?: "",
                                    correo = datosActualizados["email"] as? String ?: "",
                                    nombre_usuario = usuario,
                                    tipo_usuario = "tutor",
                                    id_tutor = null
                                )
                                perfilScope.launch {
                                    val resultadoActualizacion = actualizarPerfil(usuarioDBActualizado)
                                    if (resultadoActualizacion != null) {
                                        Alert.show("Éxito", "Perfil actualizado con éxito.", centered = true)
                                    } else {
                                        Alert.show("Error", "Error al actualizar el perfil.", centered = true)
                                    }
                                }
                            } else {
                                Alert.show("Validación Fallida", "Por favor, revise los datos ingresados.", centered = true)                            }
                        }
                    }
                }
                add(formPanel)
            }
            tab("Alumnos") {
                val tablaAlumnos = table(
                    listOf("Nombre", "Nombre de Usuario", "Fecha de Nacimiento", "Correo"),
                    setOf(TableType.BORDERED, TableType.SMALL, TableType.STRIPED, TableType.HOVER),
                    responsiveType = ResponsiveType.RESPONSIVE, tbodyDivider = true
                ) {
                    listaUsuario.forEach { usuario ->
                        row {
                            cell { +usuario.nombre }
                            cell { +usuario.nombre_usuario }
                            cell { +usuario.edad!! }
                            cell { +(usuario.correo.takeIf { !it.isNullOrBlank() } ?: "No especificado") }
                        }
                    }
                }
                add(tablaAlumnos)
                div {
                    this.style{
                        display = Display.FLEX
                        justifyContent = JustifyContent.CENTER
                        margin = 10.px
                    }
                    button("Añadir Alumno", style = ButtonStyle.INFO) {
                        style {
                            margin = 5.px
                            borderRadius = 10.px
                        }
                        onClick {
                            val addAlumnoWindow = ShowcaseVentanaAlumno("Añadir Nuevo Alumno",usuario)
                            this@PerfilApp.add(addAlumnoWindow)
                            addAlumnoWindow.show()
                        }
                    }
                    button("Refrescar Lista", style = ButtonStyle.SECONDARY) {
                        style {
                            margin = 5.px
                            borderRadius = 10.px
                        }
                        onClickLaunch {
                            actualizarListaAlumnos(tablaAlumnos)
                        }
                    }
                }

                div {
                    this.style {
                        display = Display.FLEX
                        flexDirection = FlexDirection.COLUMN
                        alignItems = AlignItems.CENTER
                    }
                    label("Selecciona un Alumno a eliminar o modificar")
                    val opcionesAlumnos = listaUsuario.map { it.nombre_usuario to it.nombre }
                    val selectAlumnos = Select(
                        options = opcionesAlumnos,
                        emptyOption = true,
                        label = "Alumnos"
                    )
                    add(selectAlumnos)
                    div {
                        this.style {
                            display = Display.FLEX
                            flexDirection = FlexDirection.ROW
                            alignItems = AlignItems.CENTER
                            justifyContent =JustifyContent.CENTER
                        }

                        button("Modificar Alumno", style = ButtonStyle.INFO){
                            style {
                                margin = 5.px
                                borderRadius = 10.px
                            }
                            onClickLaunch {
                                val alumnoSeleccionado = selectAlumnos.getValue()
                                if (!alumnoSeleccionado.isNullOrBlank()) {
                                    val modificarAlumnoWindow = ShowcaseModificarAlumno("Modificar Alumno", alumnoSeleccionado) {

                                    }
                                    this@PerfilApp.add(modificarAlumnoWindow)
                                    modificarAlumnoWindow.show()
                                } else {
                                    Alert.show("Selección Requerida", "Por favor, selecciona un alumno para modificar", centered = true)
                                }
                            }
                        }
                        button("Eliminar Alumno", style = ButtonStyle.DANGER){
                            style {
                                margin = 5.px
                                borderRadius = 10.px
                            }
                            onClickLaunch {
                                val alumnoSeleccionado = selectAlumnos.getValue()
                                if (!alumnoSeleccionado.isNullOrBlank()) {
                                    val eliminado = eliminarAlumno(alumnoSeleccionado)
                                    if (eliminado) {
                                        Alert.show("Éxito", "Usuario eliminado con éxito", centered = true)
                                        actualizarListaAlumnos(tablaAlumnos)
                                        actualizarSelect(selectAlumnos)
                                    } else {
                                        Alert.show("Error", "No se pudo eliminar el usuario.", centered = true)
                                    }
                                } else {
                                    Alert.show("Selección Requerida", "Por favor, selecciona un alumno para eliminar", centered = true)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    class ShowcaseVentanaAlumno(caption: String?, private val nombreUsuario: String, init: (ShowcaseVentanaAlumno.() -> Unit)? = null) :
        Window(caption, 300.px, 100.px, closeButton = true) {
        init {
            init?.invoke(this)

            vPanel {
                val formPanel = FormPanel<NuevoAlumno>()
                with(formPanel) {
                    add(
                        NuevoAlumno::nombre,
                        Text(label = "Nombre completo").apply { placeholder = "Nombres y Apellidos" },
                        required = true,
                        requiredMessage = "Nombre requerido"
                    )
                    add(
                        NuevoAlumno::nombre_usuario,
                        Text(label = "Nombre de usuario").apply { placeholder = "Nombre de usuario" },
                        required = true,
                        requiredMessage = "Nombre de usuario requerido"
                    )
                    add(
                        NuevoAlumno::edad,
                        DateTime(label = "Fecha de nacimiento").apply { placeholder = "YYYY-MM-DD" },
                        required = true,
                        requiredMessage = "Fecha de nacimiento requerida"
                    )
                    add(
                        NuevoAlumno::correo,
                        Text(label = "Correo").apply { placeholder = "Correo electrónico" },
                        required = false,
                        requiredMessage = "Correo requerido"
                    )
                    add(
                        NuevoAlumno::password,
                        Password(label = "Contraseña"),
                        required = true,
                        requiredMessage = "Contraseña requerida"
                    )
                    add(
                        NuevoAlumno::password2,
                        Password(label = "Confirmar Contraseña"),
                        required = true,
                        requiredMessage = "Confirmación de contraseña requerida"
                    )

                    button("Guardar Alumno", style = ButtonStyle.SUCCESS).onClickLaunch {
                        if (formPanel.validate()) {
                            val datosFormulario = formPanel.getData() as Map<String, Any?>
                            val contraseña = datosFormulario["password"] as? String
                            val confirmarContraseña = datosFormulario["password2"] as? String

                            if (contraseña == confirmarContraseña) {
                                try {
                                    registrarAlumno(datosFormulario,nombreUsuario)
                                    Alert.show(
                                        "Registro Exitoso",
                                        "Alumno registrado con exito",
                                        centered = true
                                    )
                                    formPanel.clearData()
                                } catch ( e: Exception) {
                                    Alert.show(
                                        "Error en el Registro",
                                        "No se puede registrar el alumno",
                                        centered = true
                                    )
                                }
                            } else {
                                Alert.show(
                                    "Error en el Formulario",
                                    "Las contraseñas no coinciden",
                                    centered = true
                                )
                            }
                        } else {
                            Alert.show("Error","Validación fallida",centered = true)
                        }
                    }
                }
                add(formPanel)
            }
        }
    }

    class ShowcaseModificarAlumno(caption: String?, private val nombreAlumno: String, init: (ShowcaseModificarAlumno.() -> Unit)? = null) :
        Window(caption, 300.px, 100.px, closeButton = true) {
        init {
            init?.invoke(this)
            vPanel {
                val formPanel = FormPanel<AlumnoModel>()

                val perfilScope = CoroutineScope(Dispatchers.Main + Job())
                perfilScope.launch {
                    val alumno = obtenerPerfil(nombreAlumno)
                    with(formPanel) {
                        add(
                            AlumnoModel::nombre,
                            Text(label = "Nombre completo").apply { value = alumno.nombre; placeholder = "Nombres y Apellidos" },
                            required = true,
                            requiredMessage = "Nombre requerido"
                        )
                        val fecha = Date(alumno.edad ?: "")
                        add(
                            AlumnoModel::edad,
                            DateTime(label = "Fecha de nacimiento", format = "YYYY-MM-DD", value = fecha),
                            required = true,
                            requiredMessage = "Fecha de nacimiento requerida"
                        )
                        add(
                            AlumnoModel::correo,
                            Text(label = "Correo").apply { value = alumno.correo ?: ""; placeholder = "Correo electrónico" },
                            required = false,
                            requiredMessage = "Correo requerido"
                        )
                        add(
                            AlumnoModel::password,
                            Password(label = "Contraseña").apply { value = alumno.password; placeholder = "Contraseña" },
                            required = true,
                            requiredMessage = "Contraseña requerida"
                        )
                        add(
                            AlumnoModel::password2,
                            Password(label = "Confirmar Contraseña").apply { placeholder = "Confirmar Contraseña" },
                            required = true,
                            requiredMessage = "Confirmación de contraseña requerida"
                        )

                        button("Guardar Cambios", style = ButtonStyle.SUCCESS).onClickLaunch {
                            if (formPanel.validate()) {
                                val datosFormulario = formPanel.getData() as Map<String, Any?>
                                val nombre = datosFormulario["nombre"] as? String ?: ""
                                val edadJS = datosFormulario["edad"] as? Date
                                val password = datosFormulario["password"] as? String ?: ""
                                val correo = datosFormulario["correo"] as? String
                                // Convierte la edad de JS Date a String con formato YYYY-MM-DD
                                val edad = edadJS?.let {
                                    "${it.getFullYear()}-${(it.getMonth() + 1).toString().padStart(2, '0')}-${it.getDate().toString().padStart(2, '0')}"
                                } ?: ""
                                val alumnoActualizado = UsuarioDB(
                                    nombre = nombre,
                                    nombre_usuario = nombreAlumno,
                                    edad = edad,
                                    password = password,
                                    correo = correo,
                                    tipo_usuario = "alumno"
                                )

                                try {
                                    val resultado = actualizarAlumno(alumnoActualizado)
                                    if (resultado) {
                                        Alert.show("Éxito", "Alumno actualizado con éxito", centered = true)
                                    } else {
                                        Alert.show("Error", "No se pudo actualizar el alumno", centered = true)
                                    }
                                } catch (e: Exception) {
                                    Alert.show("Error", "Ocurrió un error al actualizar: ${e.message}", centered = true)
                                }
                            } else {
                                Alert.show("Error","Validación fallida",centered = true)
                            }
                        }
                    }
                }
                add(formPanel)
            }
        }
    }

    private fun Container.addTabPanel(formPanel: FormPanel<UserModel>, perfilUsuarioDB: UsuarioDB) {
        val fechaNacimiento = perfilUsuarioDB.edad?.replace("-", "/")
        val fechaDate = fechaNacimiento?.let { Date(it) }
        with(formPanel) {
            add(UserModel::nombre, Text(label = "Nombre", value = perfilUsuarioDB.nombre))
            val emailField = Text(label = "Email", value = perfilUsuarioDB.correo)
            add(UserModel::email, emailField, validator = {
                val emailText = emailField.getValue()
                        if (!emailText.isNullOrEmpty()) {
                            val emailRegex = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
                            emailRegex.matches(emailText)
                        } else {
                            false
                        }
                    })
            add(UserModel::password, Password(label = "Contraseña", floating = true), required = true, requiredMessage = "Contraseña requerida", validatorMessage = { "Contraseña muy corta" }) {(it.getValue()?.length ?: 0) >= 8}
            add(UserModel::password2, Password(label = "Confirma tu contraseña", floating = true), required = true, requiredMessage = "Se debe confirmar la contraseña", validatorMessage = { "Contraseña muy corta" }) { (it.getValue()?.length ?: 0) >= 8}
            add(UserModel::edad, DateTime(label = "Fecha de nacimiento", format = "YYYY-MM-DD", value = fechaDate))
        }
        add(formPanel)
    }

    private suspend fun Container.actualizarSelect(select: Select) {
        val listaActualizada = consultaListaAlumnos(usuario)
        select.removeAll()
        val opcionesActualizadas = listaActualizada.map { it.nombre_usuario to it.nombre }
        select.options = opcionesActualizadas
    }
    private suspend fun Container.actualizarListaAlumnos(tabla: Table) {
        val listaActualizada = consultaListaAlumnos(usuario)
        tabla.removeAll()
        listaActualizada.forEach { usuario ->
            tabla.row {
                cell { +usuario.nombre }
                cell { +usuario.nombre_usuario }
                cell { +usuario.edad!! }
                cell { +(usuario.correo.takeIf { !it.isNullOrBlank() } ?: "No especificado") }
            }
        }
    }
    fun onDestroy() {
        perfilScope.cancel()
    }
    companion object {
        fun run(container: Container, username: String) {
            container.add(PerfilApp(container, username))
        }
    }
}
