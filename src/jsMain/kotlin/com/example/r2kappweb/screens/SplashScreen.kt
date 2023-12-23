package com.example.r2kappweb.screens

import io.kvision.core.fadeIn
import io.kvision.core.fadeOut
import io.kvision.core.style
import io.kvision.html.Div
import io.kvision.html.Image
import io.kvision.panel.Root
import io.kvision.utils.px
import kotlinx.browser.window

class SplashScreen(private val root: Root, private val onFinished: () -> Unit) {
    fun show() {
        val timeOut: Int = 2000
        val timeFadeIn: Int = 1000
        val timeFadeOut: Int = 1000
        val logo = Image("static/icon.png").apply {
            width = 200.px
            height = 200.px
        }
        root.add(logo)
        val logoText = Div("Right2Know: El Derecho a Saber").apply {
            style {
                marginTop = 10.px  // Ajusta el espacio entre el logo y el texto
                fontSize = 16.px   // Tamaño de fuente del texto
            }
        }
        logo.fadeIn(timeFadeIn) {
            root.add(logoText)
            logoText.fadeIn(timeFadeIn)
            window.setTimeout({
                logoText.fadeOut(timeFadeOut)
                logo.fadeOut(timeFadeOut) {
                    //root.dispose() usado en hilo principal, acá rompe el código se debe usar onFinished()
                    onFinished()
                }
            }, timeOut)
        }
    }
}