package com.example.r2kappweb.screens
import com.example.r2kappweb.backend.registerUsuario
import com.example.r2kappweb.backend.UsuarioDB
import io.kvision.core.onClickLaunch
import io.kvision.form.FormPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.form.time.DateTime
import io.kvision.html.Button
import io.kvision.html.ButtonStyle
import io.kvision.html.link
import io.kvision.modal.Alert
import io.kvision.panel.VPanel
import io.kvision.utils.px
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlin.js.Date

@Serializable
data class UserModel(
    val nombre: String,
    val username: String,
    @Contextual val edad: Date?,
    val email: String,
    val password: String,
    val password2: String
)

class RegisterScreen(private val onBack: () -> Unit) : VPanel() {
    init {
        margin = 20.px
        val formPanel = FormPanel<UserModel>()

        with(formPanel) {
            add(UserModel::nombre, Text(label = "Nombre completo").apply { placeholder = "Nombres Apellidos" }, required = true, requiredMessage = "Nombre requerido")
            add(UserModel::username, Text(label = "Nombre de usuario").apply { placeholder = "Usuario" }, required = true, requiredMessage = "Nombre de usuario requerido")
            val emailField = Text(label = "Email").apply {
                placeholder = "usuario@example.com"
            }
            add(UserModel::email, emailField, required = true, requiredMessage = "Email requerido", validator = {
                val emailText = emailField.getValue()
                if (!emailText.isNullOrEmpty()) {
                    val emailRegex = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
                    emailRegex.matches(emailText)
                } else {
                    false // Devolver false si el email es nulo o vacío
                }
            })
            add(UserModel::password, Password(label = "Contraseña", floating = true), required = true, requiredMessage = "Contraseña requerida",
                validatorMessage = {"Contraseña muy corta"}) {(it.getValue()?.length ?: 0) >= 8}
            add(UserModel::password2, Password(label = "Confirma tu contraseña", floating = true), required = true, requiredMessage = "Se debe confirmar la contraseña",
                validatorMessage = {"Contraseña muy corta"}) { (it.getValue()?.length ?: 0) >= 8}
            add(UserModel::edad, DateTime(label = "Fecha de nacimiento", format = "YYYY-MM-DD"), required = true, requiredMessage = "Fecha requerida")
        }

        val registerButton = Button("Registrar", style = ButtonStyle.DARK).apply {
            //onClick {
            onClickLaunch {
                //val confirmaCampos = formPanel.validate()
                if (formPanel.validate()) {
                val userModelMap = formPanel.getData() as Map<String, Any?>
                val contraseña = userModelMap["password"] as? String
                val confirmarContraseña = userModelMap["password2"] as? String

                println("contraseña: $contraseña")
                println("confirmarContraseña: $confirmarContraseña")
                //if (esValido && (contraseña == confirmarContraseña)) {
                    if (contraseña == confirmarContraseña) {
                        val userModel = formPanel.getData()
                        println("Modelo $userModel")
                        println("Nombre de usuario ${userModel.username}")
                        println("Datos del formulario: $userModelMap")

                        val nombre = userModelMap["nombre"] as? String ?: "No encontrado"
                        val username = userModelMap["username"] as? String ?: "No encontrado"
                        val email = userModelMap["email"] as? String ?: "No encontrado"
                        val password = userModelMap["password"] as? String ?: "No encontrado"
                        val password2 = userModelMap["password2"] as? String ?: "No encontrado"
                        // Fecha se debe convertir desde "Fri Dec 01 2023 00:00:00 GMT-0300 (hora de verano de Chile)"
                        val edad = userModelMap["edad"] as? Date
                        val edadFormat = edad?.let {
                            "${it.getFullYear()}-${it.getMonth() + 1}-${it.getDate()}"
                        } ?: "Fecha no encontrada"
                        println("Nombre: $nombre")
                        println("Usuario: $username")
                        println("Email: $email")
                        println("Contraseña: $password")
                        println("Confirmación: $password2")
                        println("Edad: $edad")
                        println("Edad: $edadFormat")
                        val usuario = UsuarioDB (
                            nombre = nombre,
                            nombre_usuario= username,
                            edad= edadFormat,
                            password= password,
                            correo= email,
                            tipo_usuario = "tutor"
                        )
                        registerUsuario(usuario)
                    } else {
                        Alert.show(
                            "Formulario de Registro",
                            "Las contraseñas no coinciden",
                            centered = true
                        )
                        println("Las contraseñas no coinciden")
                    }
                } else {
                    Alert.show(
                        "Formulario de Registro",
                        "Falta rellenar campos correctamente",
                        centered = true
                    )
                    println("Faltan campos")
                }
            }
        }
        add(formPanel)
        add(registerButton)
        link("← Volver", "#").onClick { onBack() }
    }
}