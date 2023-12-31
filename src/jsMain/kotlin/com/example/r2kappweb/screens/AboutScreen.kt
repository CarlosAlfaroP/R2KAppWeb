package com.example.r2kappweb.screens

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.utils.vh
import kotlinx.browser.window
class AboutScreen(private val onBack: () -> Unit) : SimplePanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.START
            alignItems = AlignItems.CENTER
            width = 100.perc
            height = 130.vh
            marginLeft = 20.px
            marginRight = 20.px
            maxWidth = 900.px
        }

        val iconImage = Image("static/icon.png").apply {
            width = 100.px
            height = 100.px
            marginTop = 150.px
        }
        add(iconImage)

        div("Bienvenido a Right2Know") {
            style {
                fontSize = 24.px
                fontWeight = FontWeight.BOLD
                margin = 20.px
            }
        }
        div {
            p("Right to Know: El derecho a saber, es una plataforma educativa y gratuita," +
                    " creada por un apasionado grupo de estudiantes de ingeniería informática en UNIACC. " +
                    "Con nosotros aprenderás de manera didáctica :)" +
                    ""
            ) {style { textAlign=
                TextAlign.JUSTIFY }}
            p("Si eres menor de 18, pídele a tu profesor o a un adulto que te cree una cuenta. " +
                    "Si eres un tutor, profesor o familiar, puedes registrarte gratuitamente con " +
                    "una cuenta de correo y podrás crear cuentas a tus alumnos desde tu perfil. " +
                    "Right2Know fomenta la participación activa en el proceso de enseñanza-aprendizaje. "
            ) {style { textAlign=
                TextAlign.JUSTIFY }}
        }

        div("Características Destacadas") {
            style {
                fontSize = 18.px
                fontWeight = FontWeight.BOLD
                margin = 20.px
            }
        }
        div {
            p("Mientras estás en R2K Artúk será tu guía! " +
                    " " +
                    "Artúk es un simpatico robot, si le das click siempre tendrá un consejo. ")
        }
        val artukImage = Image(io.kvision.require("static/artuk_presentandose.png"), shape = ImageShape.CIRCLE).apply {
            maxWidth = 100.perc
            width = 200.px
            height = 200.px
            enablePopover(
                PopoverOptions(
                    title = ("Artúk:"),
                    content = "Hola! Mi número de serie es R2K-Personal01, pero todos me dicen Artúk." +
                            " " +
                            "Soy uno de varios asistentes en la biblioteca del conocimiento. " +
                            "Haré lo mejor para poder asistirte. ",
                )
            )
        }
        artukImage.onClick {
            artukImage.showPopover()
            window.setTimeout({
                artukImage.hidePopover()
            }, 15000) // Cambia 3000 a la cantidad de milisegundos que desees (3000 ms = 3 segundos)
        }
        add(artukImage)
        div() {
            listTag(
                ListType.UL,
                listOf(
                    "Roles Personalizados: Los usuarios de Right2Know pueden registrarse como Tutor y crear alumnos dedicados. Cada rol está diseñado para satisfacer las necesidades de quienes buscan tanto aprender como enseñar.",
                    "Gestión de Usuarios Integral: Los tutores tienen el poder de crear, editar y eliminar perfiles de alumnos, brindando un entorno educativo seguro y supervisado.",
                    "Interfaz Estudiantil e Intuitiva: La interfaz de usuario de Right2Know ha sido desarrollada teniendo en cuenta la simplicidad y la accesibilidad. Queremos que tu experiencia de aprendizaje sea tan intuitiva como enriquecedora."
                )
            )
        }
        div("¿Cómo Empezar en Right2Know?") {
            style {
                fontSize = 18.px
                fontWeight = FontWeight.BOLD
                margin = 20.px
            }
        }
        div() {
            p("Explora las características como en cualquier computadora, usando el menú y los íconos. " +
                    "Simplemente revisa los programas que vienen, encontrarás que hay videos y juegos que explorar. " +
                    "Estamos aquí para hacer que tu viaje educativo sea más efectivo y satisfactorio :)"
            ) {style { textAlign=
                TextAlign.JUSTIFY }}
        }
        div {
            p("Agradecemos que te unas a nosotros en esta emocionante travesía educativa.")
            p("El Equipo de Right2Know - Estudiantes de Ingeniería Informática de UNIACC")
        }
        button("Volver", style = ButtonStyle.DARK).onClick { onBack() }
    }
}