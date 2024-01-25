package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class ConstitucionPage (private val onBack: () -> Unit) : VPanel() {
    init {
        this.style {
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
            tab ("Introducción") {
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
                    image(src = "static/banner_constitucion.png", alt = "La Constitución de Chile").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Constitución de Chile") { addCssClass("title") }
                    p("""    Una Constitución es la ley más importante de un país, Define cómo se organiza el gobierno, los derechos de las personas y cómo se deben comportar las instituciones políticas. Actúa como una guía para gobernar y organizar el Estado. También conocida como “Carta Magna” o “Ley Suprema”.
    """.trimIndent())
                    h2("Tipos de Constituciones")
                    h3("1. Según su Materialidad:")
                    ul {
                        li("Escritas: Todo en un solo documento, como la Constitución Española de 1978.")
                        li("No Escritas: Basadas en costumbres, leyes y sentencias, como en el Reino Unido.")
                    }
                    h3("2. Según su Extensión:")
                    ul {
                        li("Breves: Con pocos artículos, como la Constitución de EE.UU.")
                        li("Desarrolladas: Muy extensas, como la Constitución de la India.")
                    }
                    h3("3. Según su Capacidad de Reforma:")
                    ul {
                        li("Pétreas: No pueden modificarse, como ciertos artículos de la Constitución italiana.")
                        li("Rígidas: Difíciles de cambiar, necesitan altos quórums, como en Argentina.")
                        li("Flexibles: Fáciles de cambiar, como en países del Commonwealth.")
                    }
                    h3("4. Según su Origen:")
                    ul {
                        li("Otorgadas: Dadas por un rey o monarca.")
                        li("Impuestas: El Parlamento impone la Constitución al monarca.")
                        li("Pactadas: Acordadas entre diferentes partes.")
                        li("Aprobadas por Soberanía Popular: La gente vota por ellas, como en Islandia.")
                    }
                    h2("¿Para Qué Sirven las Constituciones?")
                    p("""    Son la base del Estado y de todas sus leyes. Establecen el marco legal y los principios fundamentales de un país. Aseguran que todas las leyes y acciones del gobierno se alineen con estos principios.
    """.trimIndent())
                    h2("El Poder Constituyente")
                    p("""    Es el poder de crear o cambiar la Constitución. Puede ser Originario (cuando se crea una nueva Constitución) o Derivado (cuando se modifica una existente). La gente, a través de su voto, es quien tiene este poder.
    """.trimIndent())
                    p()
                    h4("Quieres saber un poco más?")
                    p("Descarga el capítulo del temario en el siguiente link:")
                    link("| Descarga |", "static/documentos/05_constitucion.pdf", target = "_blank")
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Constitución en Chile") {
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
                    image(src = "static/banner_constitucion.png", alt = "La Constitución de Chile").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Constitución de Chile") { addCssClass("title") }
                    h2("¿Qué es una Constitución?")
                    p("""    Es como el manual de instrucciones de un país. Dice cómo se gobierna, qué derechos tienen las personas y cómo se organizan las instituciones.
    """.trimIndent())
                    h2("La Aventura Constitucional de Chile")
                    h3("1. Primeros Pasos (1811-1833):")
                    ul {
                        li("Después de buscar la independencia, Chile probó diferentes constituciones para organizar el nuevo país.")
                        li("La Constitución de 1833 fue la primera en durar mucho tiempo y estableció un gobierno fuerte con un presidente poderoso.")
                    }
                    h3("2. Cambios y Desafíos (1833-1925):")
                    ul {
                        li("Esta constitución duró hasta 1925, con algunas reformas en el camino.")
                        li("Fue un período de experimentación, con un intento de parlamentarismo que no funcionó muy bien.")
                    }
                    h3("3. La Constitución de 1925:")
                    ul {
                        li("Esta nueva constitución surgió de una crisis política y económica.")
                        li("Estableció un gobierno presidencialista y separó la Iglesia del Estado.")
                        li("Fue importante porque incluyó derechos sociales como educación y salud.")
                    }
                    h3("4. La Constitución de 1980:")
                    ul {
                        li("Después del golpe militar de 1973, se creó una nueva constitución.")
                        li("La Constitución de 1980 fue hecha por una comisión especial y aprobada en un plebiscito.")
                        li("Reforzó el papel del presidente y enfocó en la libertad económica y los derechos de propiedad.")
                    }
                    h2("Elementos Comunes en las Constituciones:")
                    p("""    Las tres constituciones chilenas (1833, 1925 y 1980) tienen cosas en común:""".trimIndent())
                    ul {
                        li("Un presidente fuerte.")
                        li("Un Congreso Nacional con dos cámaras.")
                        li("Respeto por los derechos fundamentales, aunque cada una los abordó de manera diferente.")
                    }
                    h2("Participación Ciudadana:")
                    p("""    Las constituciones fueron hechas mayormente por comisiones especiales, con poca participación directa de la gente.
                            Los ciudadanos podían votar en plebiscitos para aceptar o rechazar las constituciones.""".trimIndent()
                    )
                    p("""    Entender la historia de las constituciones de Chile es como viajar en el tiempo y ver cómo el país ha ido cambiando sus reglas para mejorar y adaptarse a nuevos desafíos. Cada constitución refleja las ideas y necesidades de su época, ¡y todas juntas nos cuentan la historia de Chile!""".trimIndent()
                    )
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Construcción") {
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
                    image(src = "static/banner_constitucion.png", alt = "La Constitución de Chile").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Constitución de Chile") { addCssClass("title") }
                    p("""    Imagina que es como construir un juego de LEGO gigante para un país. Define las reglas de cómo funciona todo, desde el gobierno hasta los derechos de las personas.
    """.trimIndent())

                    h2("Maneras de Hacer una Constitución")
                    h3("1. Asamblea Constituyente:")
                    ul {
                        li("Es como un equipo especial de personas elegidas para diseñar una nueva constitución.")
                        li("Representan a diferentes partes de la sociedad y trabajan juntas para crear las reglas.")
                    }
                    h3("2. Congreso o Parlamento Constituyente:")
                    ul {
                        li("Aquí, las personas que ya están en el gobierno (diputados y senadores) tienen la tarea de hacer la nueva constitución.")
                        li("Pueden trabajar todos juntos o formar un grupo especial para esta misión.")
                    }
                    h3("3. Comisión Constituyente o Comisión de Expertos:")
                    ul {
                        li("Un grupo de personas expertas, como abogados o profesores, es elegido para proponer una nueva constitución.")
                        li("Sus ideas luego necesitan ser aprobadas por el gobierno o la gente.")
                    }
                    h3("4. Otros Métodos, Como Tratados Internacionales:")
                    p("""    A veces, otros países ayudan a crear una constitución, especialmente después de una guerra o conflicto grande.""".trimIndent())
                    h2("¿Cómo se Hace en Chile?")
                    p("""    Antes, Chile no tenía un método específico para hacer una nueva constitución, solo para modificar la existente. Pero ahora, con las protestas y el deseo de cambios, se estableció un proceso para crear una nueva constitución. La gente votó en un plebiscito si querían o no una nueva constitución y qué tipo de grupo debería redactarla. Ganó la opción de hacer una nueva constitución a través de una "Convención Constitucional", un grupo de 155 personas elegidas para esta tarea. Estas personas tienen 9 meses, extensibles a 12, para escribir la nueva constitución.""".trimIndent())
                    h2("Lo Especial de Chile")
                    p("""    La Constitución de 1980 de Chile ha sido modificada varias veces, buscando mejorar y adaptarla a los tiempos. En 2014, hubo un intento de hacer una nueva constitución, pero no se completó. Ahora, en 2020, después de grandes protestas, se decidió empezar un proceso para crear una completamente nueva. Será un gran desafío, pero también una oportunidad para que la sociedad chilena decida juntos cómo quieren que sea su país en el futuro.""".trimIndent())
                    p("""    Crear una constitución es como escribir la historia de un país y decidir juntos cómo quieren vivir. Es un proceso emocionante y muy importante, ¡porque define el futuro!""".trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Mini-Juego") {
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
                    image(src = "static/banner_constitucion.png", alt = "La Constitución de Chile").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Constitución de Chile") {
                        addCssClass("title")
                    }
                    p("Prueba lo aprendido con este mini-juego")
                    p("Verdad o No?")
                    iframe(src = "https://wordwall.net/es/embed/cc653d6fcf894666a48a1e21bab8b47a?themeId=44&templateId=73&fontStackId=0") {
                        iframeWidth = 800
                        iframeHeight = 600
                        maxWidth = 900.px
                    }
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
        }
    }
}