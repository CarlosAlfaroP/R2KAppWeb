package com.example.r2kappweb.apps

import io.kvision.core.*
import io.kvision.html.div
import io.kvision.panel.FieldsetPanel
import io.kvision.panel.fieldsetPanel
import io.kvision.panel.flexPanel
import io.kvision.utils.px

class CategoryApp : DesktopWindow("Temario", "fa-solid fa-book-open", 900, 400) {
    init {
        isResizable = true
        maximizeButton = true
        minimizeButton = true
        minWidth = 400.px
        minHeight = 150.px
        height = 450.px
        width = 600.px
        padding = 2.px
        // Usar un flexPanel para organizar las Cards
        flexPanel(FlexDirection.ROW, FlexWrap.WRAP, alignContent = AlignContent.STRETCH, alignItems = AlignItems.STRETCH) {
            // Añadir Cards (usando fieldsetPanel) para cada tema
            for (i in 1..7) {
                add(createThemeCard("Tema $i", "Descripción del Tema $i"))
            }
        }
    }

    private fun createThemeCard(title: String, description: String): FieldsetPanel {
        return fieldsetPanel(title) {
            paddingTop = 10.px
            paddingBottom = 10.px
            div(description)
            // Puedes agregar aquí más elementos a la tarjeta, como botones o imágenes
        }
    }

    companion object {
        fun run(container: Container) {
            container.add(CategoryApp())
        }
    }
}