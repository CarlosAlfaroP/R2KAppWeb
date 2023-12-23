package com.example.r2kappweb.screens

import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.Button
import io.kvision.html.ButtonStyle
import io.kvision.html.link
import io.kvision.panel.VPanel
import io.kvision.utils.px

class RegisterScreen(private val onBack: () -> Unit, private val onLogin: () -> Unit) : VPanel() {
    init {
        margin = 20.px

        // Campos del formulario
        val usernameInput = Text(label = "Nombre de usuario").apply {
            placeholder = "Usuario"
        }
        val emailInput = Text(label = "Email").apply {
            placeholder = "usuario@example.com"
        }
        val passwordInput = Password(label = "Password").apply {
            placeholder = "Ingresa tu password"
        }

        // Botón de registro
        val registerButton = Button("Registrar", style = ButtonStyle.DARK)

        // Añadir componentes al panel
        add(usernameInput)
        add(emailInput)
        add(passwordInput)
        add(registerButton)
        link("← Volver", "#").onClick {
            onBack()
        }
        // Evento del botón de registro
        registerButton.onClick  {
            val username = usernameInput.value
            val email = emailInput.value
            val password = passwordInput.value
            // Aquí puedes manejar los datos recogidos (username, email, password)
            console.log("Username: $username, Email: $email, Password: $password")
            onBack()
        }
    }
}