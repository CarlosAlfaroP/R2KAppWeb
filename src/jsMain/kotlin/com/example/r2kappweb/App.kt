package com.example.r2kappweb

import com.example.r2kappweb.screens.*
import io.kvision.*
import io.kvision.core.*
import io.kvision.panel.Root
import io.kvision.utils.perc
import io.kvision.utils.vh

class App : Application() {
    private lateinit var mainPanel: Root
    override fun start() {
        mainPanel = Root("r2kappweb") {
            style {
                width = 100.perc
                height = 100.vh
                display = Display.FLEX
                flexDirection = FlexDirection.COLUMN
                justifyContent = JustifyContent.CENTER
                alignItems = AlignItems.CENTER
            }
        }
        showHomeScreen("carlosalfaro")
        //showSplashScreen()
    }
    private fun showSplashScreen() {
        val splashScreen = SplashScreen(mainPanel) {
            loadMainScreen()
        }
        splashScreen.show()
    }
    private fun loadMainScreen() {
        mainPanel.removeAll()
        mainPanel.add(MainScreen(
            onAboutClick = {
                showAboutScreen()
            },
            onLoginClick = {
                showLoginScreen()
            }
        ))
    }
    private fun showAboutScreen() {
        mainPanel.removeAll()
        mainPanel.add(AboutScreen {
            loadMainScreen()
        })
    }
    private fun showLoginScreen() {
        mainPanel.removeAll()
        mainPanel.add(
            LoginScreen(
                onBack =  { loadMainScreen() },
                onRegister = { showRegisterScreen() },
                onLoginSuccess = { username -> showHomeScreen(username) }
            )
        )
    }
    private fun showRegisterScreen() {
        mainPanel.removeAll()
        mainPanel.add(RegisterScreen(
            onBack = { showLoginScreen() }
        ))
    }
    private fun showHomeScreen(username: String) {
        mainPanel.removeAll()
        mainPanel.add(HomeScreen(
            mainPanel,
            username,
            onLogout = { loadMainScreen() }
        ))
    }
}
fun main() {
    startApplication(::App, module.hot, BootstrapModule, BootstrapCssModule, RichTextModule, BootstrapUploadModule, FontAwesomeModule, BootstrapIconsModule, CoreModule)
}