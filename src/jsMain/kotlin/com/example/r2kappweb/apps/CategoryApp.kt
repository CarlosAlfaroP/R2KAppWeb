package com.example.r2kappweb.apps

import io.kvision.core.*
import io.kvision.html.div
import io.kvision.html.image
import io.kvision.html.link
import io.kvision.panel.FieldsetPanel
import io.kvision.panel.fieldsetPanel
import io.kvision.panel.flexPanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.utils.vh

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

        flexPanel(FlexDirection.ROW, FlexWrap.WRAP, alignContent = AlignContent.STRETCH, alignItems = AlignItems.STRETCH) {
            justifyContent = JustifyContent.CENTER
            for (i in 1..7) {
                add(createCard("Tema $i", "Descripción del Tema $i", "Una descripcion de $i"))
            }
        }
    }
    private fun createCard(titulo: String, subtitulo: String, descripcion: String): FieldsetPanel {
        return fieldsetPanel(titulo) {
            paddingTop = 10.px
            paddingBottom = 10.px
            margin = 10.px
            div(subtitulo){ addCssClass("card-subtitle")}
            image(src = "static/banner.png", alt = "").apply { width = 100.perc }
            div(descripcion) { addCssClass("card-text")}
            link("Ir a...", "#")
        }
    }
    companion object {
        fun run(container: Container) {
            container.add(CategoryApp())
        }
    }
}