package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class SociedadPage (private val onBack: () -> Unit) : VPanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
        }
        // Título del artículo
        image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
            width = 100.perc
            maxHeight = 350.px
            maxWidth = 600.px
        }

        h1("La Sociedad, el Derecho y el Pensamiento Político") {
            addCssClass("title")
        }
        p()
        button("Volver", style = ButtonStyle.DARK).onClick {
            onBack()
        }
    }
}