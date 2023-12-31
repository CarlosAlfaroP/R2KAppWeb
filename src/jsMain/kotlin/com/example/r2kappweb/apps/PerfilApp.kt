package com.example.r2kappweb.apps

import com.example.r2kappweb.backend.*
import com.example.r2kappweb.screens.UserModel
import io.kvision.core.*
import io.kvision.form.FormPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.form.time.DateTime
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.modal.Alert
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.table.*
import io.kvision.utils.px
import io.kvision.window.Window
import kotlinx.coroutines.*
import kotlin.js.Date

class PerfilApp(private val root: Container, private val usuario: String) : DesktopWindow("Perfil", "fa-solid fa-book-open", 400, 300) {
    private val perfilScope = CoroutineScope(Dispatchers.Main + Job())
    init {
        height = 550.px
        perfilScope.launch {
            println("Start launch")
            val perfilUsuario = obtenerPerfil(usuario)
            println("usuario obtenido $perfilUsuario")
            val consultaTutor  = consultaTutor(usuario)
            println("el valor de la consulta es $consultaTutor")
            val formPanel = FormPanel<UserModel>()
            val listaUsuario = consultaListaAlumnos(usuario)
            println("La lista es: $listaUsuario")
            if (consultaTutor) {
                println("if true")
                this@PerfilApp.addTutorTabPanel(formPanel, perfilUsuario,listaUsuario)
            } else {
                println("if false")
                this@PerfilApp.addTabPanel(formPanel, perfilUsuario)
            }
        }
    }

    private fun Container.addTutorTabPanel(formPanel: FormPanel<UserModel>, perfilUsuarioDB: UsuarioDB, listaUsuario: List<UsuarioDB>) {
        val fechaNacimiento = perfilUsuarioDB.edad?.replace("-", "/")
        val fechaDate = fechaNacimiento?.let { Date(it) }
        println("replace: $fechaDate")
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
                            false // Devolver false si el email es nulo o vacío
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
                                val datosActualizados = formPanel.getData()
                                println("datosActualizados: $datosActualizados")
                                //TODO actualizarPerfil(datosActualizados)
                            } else {
                                println("Validación fallida")
                                //TODO Manejar la falla de validación
                            }
                        }
                    }
                }
                add(formPanel)
            }
            tab("Alumnos") {
                table(
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
                button("Añadir Alumno", style = ButtonStyle.INFO).onClick {
                    val addAlumnoWindow = ShowcaseVentanaAlumno("Añadir Nuevo Alumno",usuario)
                    this@PerfilApp.add(addAlumnoWindow)
                    addAlumnoWindow.show()
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
                        required = false,
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
                                println("datosAlumno: $datosFormulario")
                                registrarAlumno(datosFormulario,nombreUsuario)
                            } else {
                                Alert.show(
                                    "Error en el Formulario",
                                    "Las contraseñas no coinciden",
                                    centered = true
                                )
                                println("Las contraseñas no coinciden")
                            }
                        } else {
                            println("Validación fallida")
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

    fun onDestroy() {
        perfilScope.cancel()
    }
    companion object {
        fun run(container: Container, username: String) {
            container.add(PerfilApp(container, username))
        }
    }
}
