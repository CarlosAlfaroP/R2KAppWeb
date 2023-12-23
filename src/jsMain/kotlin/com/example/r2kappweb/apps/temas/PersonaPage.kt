package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.panel.VPanel
import io.kvision.utils.perc
import io.kvision.utils.vh

class PersonaPage : VPanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
        }
        // Título del artículo
        h1("Derechos Humanos en la Vida Diaria: Descubriendo su Importancia") {
            addCssClass("title")
        }
        // Introducción
        p("""
            Los derechos humanos son un tema que a menudo se asocia con grandes eventos históricos o situaciones extremas de violencia y opresión. 
            Sin embargo, ¿alguna vez te has detenido a pensar en cómo los derechos humanos también están presentes en tu vida diaria? 
            Acompáñanos en este viaje mientras exploramos cómo los derechos humanos influyen en cada momento de nuestras vidas.
        """.trimIndent())
        // Secciones del artículo
        h2("Fundamentos de los Derechos Humanos en la Vida Diaria")
        p("Los derechos humanos son aquellos derechos que poseemos simplemente por ser seres humanos...")

        h2("Derechos en Acción en la Vida Cotidiana")
        p("Los derechos humanos están presentes en nuestra vida diaria de muchas maneras...")

        h2("Derechos en Situaciones Cotidianas")
        p("Los derechos humanos son diversos pero universales...")

        h2("Responsabilidad Común")
        p("Es esencial recordar que los derechos humanos no son solo para situaciones extremas...")

        // Conclusión o llamado a la acción
        p("Entender cómo los derechos humanos están presentes en nuestra vida diaria es fundamental... ¡Vivamos con dignidad, libertad y justicia en nuestro día a día!")
        iframe(src = "https://www.youtube.com/embed/7c0Toimm8U4?si=NfduDqw6T-siK_Gk") {
            width = 100.perc
            iframeWidth = 800
            iframeHeight = 400
        }
        p()
        h2("Valida lo que aprendiste! Crees poder?")
        p()
        iframe(src = "https://wordwall.net/es/embed/b897e4f1bb94432385308aed4305f37e?themeId=1&templateId=3&fontStackId=2") {
            width = 50.perc
            iframeWidth = 500
            iframeHeight = 380
        }
    }

}