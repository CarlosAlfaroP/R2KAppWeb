package com.example.r2kappweb.screens

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.utils.vh

class AboutScreen(private val onBack: () -> Unit) : SimplePanel() {
    init {
        this.style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            width = 100.perc
            height = 100.vh
        }

        val iconImage = Image("static/icon.png").apply {
            width = 100.px
            height = 100.px
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
            p("Right2Know es una plataforma educativa creada por un apasionado grupo de estudiantes de ingeniería informática en UNIACC. Nuestra aplicación ha sido diseñada para revolucionar la experiencia de desarrollo, aprovechándolo para la creación de una plataforma educativa, brindando herramientas y recursos innovadores a estudiantes y tutores por igual.") {style { textAlign=
                TextAlign.JUSTIFY }}
            p("En Right2Know, nos esforzamos por impulsar el aprendizaje de manera colaborativa y efectiva. Nuestra misión es proporcionar a los estudiantes y tutores una plataforma que fomente la excelencia académica y la participación activa en el proceso de enseñanza-aprendizaje.") {style { textAlign=
                TextAlign.JUSTIFY }}
        }

        div("Características Destacadas") {
            style {
                fontSize = 18.px
                fontWeight = FontWeight.BOLD
                margin = 20.px
            }
        }
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
            p("¡Explora las emocionantes características de Right2Know usando el menú de navegación! Desde la gestión de usuarios hasta la participación en actividades educativas, estamos aquí para hacer que tu viaje educativo sea más efectivo y satisfactorio.") {style { textAlign=
                TextAlign.JUSTIFY }}
        }
        div {
            p("Agradecemos que te unas a nosotros en esta emocionante travesía educativa.")
            p("El Equipo de Right2Know - Estudiantes de Ingeniería Informática de UNIACC")
        }
        button("Volver", style = ButtonStyle.DARK).onClick { onBack() }
    }
}