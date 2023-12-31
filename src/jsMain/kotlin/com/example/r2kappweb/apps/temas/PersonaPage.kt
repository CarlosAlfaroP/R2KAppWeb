package com.example.r2kappweb.com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.window.Window

class PersonaPage(private val onBack: () -> Unit) : VPanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            margin = 50.px
        }
        // Título del artículo
        image(src = "static/banner_persona.png", alt = "Persona y Derechos Humanos").apply {
            width = 100.perc
            maxHeight = 350.px
            maxWidth = 600.px
        }

        h1("La Persona y Los Derechos Humanos") {
            addCssClass("title")
        }
        h2("Explorando Nuestra Naturaleza")
        // Introducción
        p("""
            La humanidad es un mosaico de experiencias y derechos inherentes. Este artículo examina la complejidad y belleza de la naturaleza humana y su relación intrínseca con los derechos humanos. A través de nuestra capacidad única para crear cultura y vivir en comunidades, resaltamos la importancia de entender y proteger la dignidad humana en todas sus formas.
            Los derechos humanos son un tema que a menudo se asocia con grandes eventos históricos o situaciones extremas de violencia y opresión. 
            Sin embargo, ¿alguna vez te has detenido a pensar en cómo los derechos humanos también están presentes en tu vida diaria? 
            Acompáñanos en este viaje mientras exploramos cómo los derechos humanos influyen en cada momento.
        """.trimIndent())
        // Secciones del artículo
        h2("La Singularidad del Ser Humano")
        p("Cada persona lleva consigo una mezcla única de influencias biológicas y culturales. Este tejido complejo de experiencias y aprendizajes forma nuestra identidad y moldea nuestras interacciones con el mundo. Reconocer esta singularidad es esencial para entender la importancia de los derechos humanos.")
        p("Los derechos humanos son aquellos derechos que poseemos simplemente por ser seres humanos...")

        h2("Los Fundamento de Nuestra Sociedad")
        p("Los derechos humanos no son solo un conjunto de normas legales; son la base sobre la cual se construye una sociedad justa y equitativa. Estos derechos abarcan desde la libertad de expresión hasta el derecho a una vida digna, subrayando la interconexión entre la individualidad y el bienestar colectivo.")
        p("Los derechos humanos están presentes en nuestra vida diaria de muchas maneras...")
        p("")
        p("Con este conocimiento, nos enfrentamos al desafío y la oportunidad de crear un mundo donde cada persona pueda desarrollarse plenamente. La promoción y protección de los derechos humanos no solo es un deber legal, sino también una invitación a cultivar una sociedad más compasiva y conectada.")
        p("Es esencial recordar que los derechos humanos no son solo para situaciones extremas...")

        // Inctustacion de video
        p("Entender cómo los derechos humanos están presentes en nuestra vida diaria es fundamental... ¡Vivamos con dignidad, libertad y justicia en nuestro día a día!")
        iframe(src = "https://www.youtube.com/embed/7c0Toimm8U4?si=NfduDqw6T-siK_Gk") {
            width = 100.perc
            iframeWidth = 500
            iframeHeight = 380
            maxWidth = 600.px
            maxHeight = 400.px
        }
        p()
        // Incrustacion de iframe con un Juego
        h2("Valida lo que aprendiste! Crees poder?")
        p()
        button("Click acá y compruébalo!!" , style = ButtonStyle.DARK, icon = "far fa-window-maximize").onClick {
            val sw = ShowcaseWindow("R2K Games: Personas y Derechos") {
            }
            this@PersonaPage.add(sw)
        }
        p()
        button("Volver", style = ButtonStyle.DARK).onClick {
            onBack()
        }
    }
}
class ShowcaseWindow(caption: String?, init: (ShowcaseWindow.() -> Unit)? = null) :
    Window(caption, 600.px, 600.px, closeButton = true) {
    init {
        init?.invoke(this)
        vPanel {
            margin = 10.px
            display = Display.FLEX
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            iframe(src = "https://wordwall.net/es/embed/b897e4f1bb94432385308aed4305f37e?themeId=1&templateId=3&fontStackId=2") {
                iframeWidth = 500
                iframeHeight = 500
                maxWidth = 900.px
            }
        }
        onEvent {
            dragStartWindow = {
                self.getElement()?.style?.opacity = "0.5"
            }
            dragEndWindow = {
                self.getElement()?.style?.opacity = "1.0"
            }
        }
    }
}