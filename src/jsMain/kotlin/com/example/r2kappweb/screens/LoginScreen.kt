package com.example.r2kappweb.screens

import io.kvision.core.Display
import io.kvision.core.JustifyContent
import io.kvision.core.style
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.ButtonStyle
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.link
import io.kvision.panel.VPanel
import io.kvision.utils.px

class LoginScreen(private val onBack: () -> Unit, private val onRegister: () -> Unit, private val onLoginSuccess: () -> Unit) : VPanel() {
    init {
        margin = 20.px
        val usernameInput = Text(label = "Usuario").apply {
            placeholder = "Invitado"
        }
        val passwordInput = Password(label = "Contraseña").apply {
            placeholder = "*******"
        }
        add(usernameInput)
        add(passwordInput)

        div {
            style {
                display = Display.FLEX
                justifyContent = JustifyContent.CENTER
            }
            button("Ingresar", style = ButtonStyle.DARK) {
                style {
                    margin = 10.px
                    borderRadius = 10.px
                }
                onClick {
                    val username = usernameInput.value
                    val password = passwordInput.value
                    console.log("Login attempt with Username: $username, Password: $password")
                    onLoginSuccess()
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
        link("← Volver", "").onClick { onBack() }
    }
}