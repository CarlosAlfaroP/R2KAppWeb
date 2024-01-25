package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class DemocraciaPage (private val onBack: () -> Unit) : VPanel() {
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
                    image(src = "static/banner_democracia.png", alt = "La Democracia y la Ciudadanía").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Democracia y la Ciudadanía") { addCssClass("title") }
                    p("""    La palabra "democracia" viene del griego y significa "gobierno del pueblo". Fue creada en la antigua Atenas para describir un sistema donde el poder lo tiene la población.
    """.trimIndent())
                    h2("¿Cómo Entendemos la Democracia Hoy?")
                    ul {
                        li("La democracia es un sistema político donde el pueblo tiene el poder a través de instituciones y procesos, como las elecciones.")
                        li("Es más que solo un tipo de gobierno; también se asocia con la libertad, igualdad, justicia social y respeto a las minorías.")
                    }
                    h2("Democracia y Valores Humanos:")
                    ul {
                        li("La democracia se basa en el respeto a la dignidad humana. Todos merecen respeto y consideración.")
                        li("En una sociedad democrática, las personas son libres de tomar decisiones y elegir.")
                        li("La democracia promueve y protege los derechos humanos, como se menciona en la Declaración Universal de los Derechos Humanos.")
                    }
                    h2("Democracia en la Práctica:")
                    ul {
                        li("La democracia se expresa a través de elecciones libres, donde todos pueden votar de manera secreta y justa.")
                        li("Aunque la democracia es un buen sistema, no es perfecta y puede mejorar o empeorar dependiendo de cómo se maneje.")
                    }
                    h2("¿Qué no es Democracia?")
                    p("""    La democracia antigua de Grecia, por ejemplo, no incluía a mujeres, esclavos ni a otros grupos, por lo que hoy no se consideraría realmente democrática.
    """.trimIndent())
                    p("""    En resumen, la democracia es un sistema en el que el poder está en manos del pueblo. Implica libertad, igualdad, respeto y la protección de los derechos humanos. Aunque es un buen sistema, siempre hay espacio para mejorar y asegurarse de que todos en la sociedad tengan voz y sean respetados.
    """.trimIndent())
                    p()
                    h4("Quieres saber un poco más?")
                    p("Descarga el capítulo del temario en el siguiente link:")
                    link("| Descarga |", "static/documentos/04_democracia.pdf", target = "_blank")
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Democracia") {
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
                    image(src = "static/banner_democracia.png", alt = "La Democracia y la Ciudadanía").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Democracia y la Ciudadanía") { addCssClass("title") }
                    h2("Lo que Todo Joven Debe Saber")
                    p("""    La democracia no es solo una palabra; es una forma de vivir y gobernar. Aunque no hay un solo tipo de democracia, hay algunas cosas básicas que todas tienen en común.
    """.trimIndent())
                    h2("Características Principales de la Democracia:")
                    ul {
                        li("Elecciones Libres y Justas: Todos pueden votar y ser candidatos, aunque a veces hay reglas sobre edad y dónde vives.")
                        li("Libertad de Expresión: Puedes hablar de temas políticos sin miedo a ser castigado.")
                        li("Información Independiente: Hay fuentes de noticias y medios que no están controlados por el gobierno y están protegidos por la ley.")
                        li("Libertad de Asociación: Puedes unirte y formar grupos políticos, como partidos o asociaciones.")
                    }
                    h2("¿Qué Hace que una Democracia sea de Calidad?")
                    ul {
                        li("Participación: Todos deben poder usar sus derechos políticos, como votar y unirse a grupos.")
                        li("Estado de Derecho: Las leyes deben ser justas, conocidas y aplicadas igualmente a todos.")
                        li("Competencia Política: Debe haber competencia entre partidos para que haya alternancia en el poder.")
                        li("Rendición de Cuentas: Los líderes deben explicar y justificar sus decisiones.")
                        li("Sistema de Contrapesos: Debe haber instituciones que controlen a los gobernantes.")
                    }
                    h2("Derechos en una Democracia:")
                    ul {
                        li("Derechos Políticos: Votar, ser elegido, formar partidos.")
                        li("Derechos Civiles: Libertad personal, de expresión, de pensamiento, de reunión.")
                        li("Derechos Sociales: Trabajo digno, salud, educación, vivienda.")
                    }
                    h2("La Democracia en Chile:")
                    p("""    Chile es una república democrática, según su Constitución.
            Reconoce y garantiza los derechos humanos.
            Se basa en la igualdad, la libertad y el respeto a la dignidad de todas las personas.
    """.trimIndent())
                    h2("Valores Esenciales de la Democracia:")
                    ul {
                        li("Dignidad de la Persona: Todos valen lo mismo, sin importar quiénes son.")
                        li("Libertad: Puedes tomar tus propias decisiones.")
                        li("Igualdad: Todos tienen los mismos derechos y oportunidades.")
                        li("Respeto a los Derechos Humanos: El Estado y los ciudadanos deben respetar y promover estos derechos.")
                        li("Autodeterminación del Pueblo: El poder viene del pueblo, que elige cómo quiere ser gobernado.")
                    }
                    p("""    La democracia es mucho más que votar. Es una forma de asegurarse de que todos tienen voz y se respetan sus derechos. Es importante entenderla y participar en ella para que funcione bien.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Gobierno") {
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
                    image(src = "static/banner_democracia.png", alt = "La Democracia y la Ciudadanía").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Democracia y la Ciudadanía") { addCssClass("title") }
                    h2("Sus Diferentes Formas y lo que Significan")
                    h2("1. Gobierno Presidencialista")
                    ul {
                        li("¿Qué es? Es cuando un Presidente es tanto Jefe de Estado como Jefe de Gobierno.")
                        li("Origen: Empezó en EE.UU. en 1787.")
                        li("Características: El Presidente tiene bastante poder. No puede ser removido fácilmente y hay una separación clara entre los poderes del gobierno.")
                        li("Ejemplo: Chile es presidencialista. El Presidente es elegido directamente por el pueblo.")
                    }
                    h2("2. Gobierno Parlamentario")
                    ul {
                        li("¿Qué es? Aquí, el gobierno viene del parlamento. Hay un Jefe de Gobierno y un Jefe de Estado, pero el Jefe de Estado generalmente tiene un rol más simbólico.")
                        li("Tipos: Monárquico y Republicano.")
                        li("Características: El gobierno trabaja junto con el parlamento y puede ser removido por ellos.")
                    }
                    h2("3. Gobierno Semipresidencial")
                    ul {
                        li("¿Qué es? Es una mezcla de presidencialista y parlamentario. Hay un Presidente y un Primer Ministro, y ambos tienen poder en el gobierno.")
                        li("Ejemplo: Francia, donde el Presidente es elegido por el pueblo y el Primer Ministro es elegido por el parlamento.")
                    }
                    p("""    Entender cómo funcionan los gobiernos te ayudará a comprender mejor las noticias y lo que ocurre en el mundo. Cada tipo tiene sus ventajas y desventajas, y la forma en que un país decide gobernarse dice mucho sobre su historia y su gente.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Ciudadanía") {
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
                    image(src = "static/banner_democracia.png", alt = "La Democracia y la Ciudadanía").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Democracia y la Ciudadanía") { addCssClass("title") }
                    p("""    Ciudadanía viene de la necesidad de las personas de vivir en sociedad y la interdependencia entre ellas. En Grecia antigua, los ciudadanos participaban directamente en el gobierno. En Roma, la ciudadanía se expandió con el Imperio, y no todos eran ciudadanos; las mujeres, por ejemplo, no tenían derechos políticos.
    """.trimIndent())
                    h2("¿Quiénes son Ciudadanos según la Constitución Chilena?")
                    ul {
                        li("Son chilenos mayores de 18 años y que no han sido condenados a penas graves.")
                        li("Tienen derecho a votar y a ser elegidos para cargos públicos.")
                    }
                    h2("Ciudadanía para Chilenos en el Extranjero")
                    p("""    Los chilenos que viven fuera de Chile también pueden votar en elecciones presidenciales y plebiscitos nacionales.
    """.trimIndent())
                    h2("Ciudadanía y Nacionalidad")
                    p("""    Hay reglas especiales para hijos de chilenos nacidos en el extranjero o para quienes obtienen la nacionalidad chilena por gracia. Estos pueden ejercer sus derechos de ciudadanía si viven más de un año en Chile.
    """.trimIndent())
                    h2("Perder la Ciudadanía")
                    p("""    Se puede perder por perder la nacionalidad chilena, por condenas graves o por delitos de terrorismo o tráfico de drogas. Pero se puede recuperar la ciudadanía después de cumplir la condena o pidiendo rehabilitación al Senado.
    """.trimIndent())
                    h2("Derecho de Voto para Extranjeros")
                    p("""    Los extranjeros que viven en Chile más de cinco años, mayores de 18 años y que no han sido condenados a penas graves, pueden votar.
    """.trimIndent())
                    h2("Cambios en el Concepto a lo Largo de la Historia")
                    p("""    En la Edad Media, con el cristianismo, la visión cambia, pero Santo Tomás de Aquino retoma la importancia de la vida terrenal. La Ilustración y las revoluciones de fines del siglo XVIII y comienzos del XIX enfatizan la igualdad y la libertad. La Declaración de Independencia de EE.UU. y la Declaración de los Derechos del Hombre y el Ciudadano en Francia son hitos importantes.
    """.trimIndent())
                    h2("Educación y Formación Ciudadana en Chile")
                    p("""    Tradicionalmente se enseñaba sobre el sistema de gobierno y la historia de Chile. Ahora se enfoca en desarrollar habilidades y actitudes para una participación informada y activa. Ley Nº 20.911 establece la formación ciudadana como un eje en la educación, promoviendo valores y conocimientos para el desarrollo del país.
    """.trimIndent())
                    p("""    Es importante entender que ser ciudadano implica no solo derechos, sino también responsabilidades y un compromiso con la sociedad en la que vivimos. La educación ciudadana nos ayuda a comprender mejor nuestro papel en la comunidad y a participar de manera activa y consciente.
    """.trimIndent())
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
                    image(src = "static/banner_democracia.png", alt = "La Democracia y la Ciudadanía").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Democracia y la Ciudadanía") { addCssClass("title") }
                    p("Prueba lo aprendido con este mini-juego")
                    p("Arrastra y suelta las palabras junto a su definición")
                    iframe(src = "https://wordwall.net/es/embed/f317523790ef48df95988d50744fa65b?themeId=49&templateId=3&fontStackId=0") {
                        iframeWidth = 800
                        iframeHeight = 600
                        maxWidth = 900.px
                    }
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
        }
    }
}