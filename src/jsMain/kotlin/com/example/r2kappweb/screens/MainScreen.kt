package com.example.r2kappweb.screens

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.utils.vh

class MainScreen(private val onAboutClick: () -> Unit,private val onLoginClick: () -> Unit) : SimplePanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            height = 100.vh
        }
        val artukImage = Image(io.kvision.require("static/artuk_saludando.png"), shape = ImageShape.CIRCLE).apply {
            maxWidth = 100.perc
            width = 200.px
            height = 200.px
            enablePopover(
                PopoverOptions(
                    title = ("Este es Artúk"),
                    content = "Hola! Yo soy Artúk y te guiaré en la aplicación."
                )
            )
        }
        add(artukImage)
        div("Bienvenido a 'El Derecho a Saber', la WebApp.")
        div {
            style {
                display = Display.FLEX
                justifyContent = JustifyContent.CENTER
            }
            button("Acerca de la App", style = ButtonStyle.SECONDARY) {
                style {
                    margin = 5.px
                    borderRadius = 10.px
                }
                onClick {
                    onAboutClick()
                }
            }
            button("Login", style = ButtonStyle.DARK) {
                style {
                    margin = 5.px
                    borderRadius = 10.px
                }
                onClick {
                    onLoginClick()
                }
            }
        }
    }

}