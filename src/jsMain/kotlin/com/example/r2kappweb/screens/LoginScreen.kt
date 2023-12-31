package com.example.r2kappweb.screens

import com.example.r2kappweb.backend.loginUsuario
import io.kvision.core.*
import io.kvision.form.FormPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.utils.vh
import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val username: String,
    val password: String
)

@Suppress("CAST_NEVER_SUCCEEDS")
class LoginScreen(private val onBack: () -> Unit, private val onRegister: () -> Unit, private val onLoginSuccess: (String) -> Unit) : VPanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            width = 100.perc
            height = 100.vh
        }
        margin = 20.px
        val formPanel = FormPanel<Login>()
        val iconImage = Image("static/icon.png").apply {
            width = 150.px
            height = 150.px
            marginTop = 150.px
            marginBottom = 50.px
        }
        val botones = div {
            style {
                display = Display.FLEX
                justifyContent = JustifyContent.CENTER
            }
            button("Ingresar", style = ButtonStyle.DARK) {
                style {
                    margin = 10.px
                    borderRadius = 10.px
                }
                onClickLaunch {
                    println("Click")
                    val confirmarCampos = formPanel.validate()
                    if (confirmarCampos) {
                        val loginData = formPanel.getData() as Map <String, String>
                        val username = loginData["username"] ?: "No encontrado"
                        val password = loginData["password"] ?: "No encontrado"
                        console.log("Login attempt with Username: $username, Password: $password")
                        val loginExitoso = loginUsuario( username, password )
                        if (loginExitoso) {
                            console.log("Inicio de sesión exitoso para el usuario: $username")
                            onLoginSuccess(username)
                        } else {
                            console.log("Error de usuario/contraseña")
                        }
                    } else {
                        println("Usuario vacio")
                    }
                }
            }

            button("Registrar", style = ButtonStyle.SECONDARY) {
                style {
                    margin = 10.px
                    borderRadius = 10.px
                }
                onClick {
                    onRegister()
                }
            }
        }
        val linkVolver = div { link("← Volver").onClick { onBack() } }

        add(iconImage)
        with(formPanel) {
            add(
                Login::username,
                Text(label = "Nombre de usuario", floating = true).apply { placeholder = "Usuario" },
                required = true,
                requiredMessage = "Nombre de usuario requerido"
            )
            add(
                Login::password,
                Password(label = "Contraseña", floating = true),
                required = true,
                requiredMessage = "Contraseña requerida"
            )
        }
        add(formPanel)
        add(botones)
        add(linkVolver)
    }
}