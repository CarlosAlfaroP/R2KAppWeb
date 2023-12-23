package com.example.r2kappweb.apps.temas

import io.kvision.html.h1
import io.kvision.html.h2
import io.kvision.html.p
import io.kvision.panel.SimplePanel
import io.kvision.panel.VPanel

class PersonaPage : VPanel() {
    init {
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
    }

}