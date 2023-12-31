package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.*
import io.kvision.utils.perc
import io.kvision.utils.px
class FamiliaPage (private val onBack: () -> Unit) : VPanel() {
    init {
        style {
            display = Display.FLEX
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
        }
        tabPanel {
            style {
                display = Display.FLEX
                flexDirection = FlexDirection.COLUMN
                justifyContent = JustifyContent.CENTER
                alignItems = AlignItems.CENTER
                width = 100.perc
            }
            tab("Introducción") {
                vPanel {
                    style {
                        display = Display.FLEX
                        flexDirection = FlexDirection.COLUMN
                        justifyContent = JustifyContent.CENTER
                        alignItems = AlignItems.CENTER
                        width = 100.perc
                        marginLeft = 20.px
                        marginRight = 10.px
                        maxWidth = 900.px
                    }
                    image(src = "static/banner_familia.png", alt = "La familia y la sociedad").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }

                    h1("La familia y la sociedad") {
                        addCssClass("title")
                    }
                    // Introducción al artículo
                    p("""    La familia es el núcleo fundamental de nuestras sociedades, proporcionando amor, apoyo y un sentido de comunidad. Este artículo explora los distintos aspectos de la vida familiar, desde los desafíos que enfrenta hasta la importancia del amor y el apoyo mutuo.
""".trimIndent())
                    // Sección Adicional - Desafíos y Apoyo Legal
                    h2("Desafíos y Apoyo Legal para las Familias")
                    p("""    En muchas partes del mundo, las familias enfrentan desafíos como la falta de vivienda o el acceso limitado a la educación. Las leyes internacionales y locales buscan abordar estos desafíos, ofreciendo apoyo a través de programas de asistencia y educación. Esto muestra cómo las comunidades y gobiernos trabajan juntos para asegurar el bienestar de todas las familias.
""".trimIndent())
                    // Sección Adicional - El Amor y el Apoyo en la Familia
                    h2("El Amor y el Apoyo en la Familia")
                    p("""    El corazón de cada familia es el amor y el apoyo mutuo. Las familias comparten tradiciones, celebraciones y se ayudan en los momentos difíciles. Esta unión y cuidado mutuo son fundamentales para el desarrollo y la felicidad de sus miembros, especialmente de los niños. Estas interacciones fortalecen los lazos familiares y contribuyen a la creación de recuerdos valiosos.
""".trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab("Tipos") {
                // Título del artículo
                image(src = "static/banner_familia.png", alt = "La familia y la sociedad").apply {
                    width = 100.perc
                    maxHeight = 350.px
                    maxWidth = 600.px
                }

                h1("La familia y la sociedad") {
                    addCssClass("title")
                }
                p()
                button("Volver", style = ButtonStyle.DARK).onClick {
                    onBack()
                }
            }
            tab("Acuerdos") {
                // Título del artículo
                image(src = "static/banner_familia.png", alt = "La familia y la sociedad").apply {
                    width = 100.perc
                    maxHeight = 350.px
                    maxWidth = 600.px
                }

                h1("La familia y la sociedad") {
                    addCssClass("title")
                }
                p()
                button("Volver", style = ButtonStyle.DARK).onClick {
                    onBack()
                }
            }
        }
    }
}