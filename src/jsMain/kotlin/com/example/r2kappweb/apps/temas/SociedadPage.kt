package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
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
                    }// Título del artículo
                    image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Sociedad, el Derecho y el Pensamiento Político") {addCssClass("title")}
                    p("""
            Las personas somos seres sociales, lo que significa que nos gusta y necesitamos estar con otros.
            No podemos vivir completamente solos; siempre formamos grupos y sociedades.
            """.trimIndent()
                    )
                    h2("¿Cómo se Forman las Sociedades?")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Comenzamos en grupos pequeños, como familias o clanes.",
                            "Con el tiempo, nos volvimos sedentarios (nos quedamos en un lugar en vez de movernos todo el tiempo).",
                            "Empezamos a dividir el trabajo y a desarrollarnos económicamente.",
                            "Esto llevó a la creación de sociedades más grandes y complejas, como los países y las organizaciones internacionales."
                        )
                    )
                    h2("¿Por Qué Necesitamos la Sociedad?")
                    listTag(
                        ListType.UL,
                        listOf(
                            "No podemos satisfacer todas nuestras necesidades solos.",
                            "En la sociedad, crecemos y nos desarrollamos como personas.",
                            "Formamos parte de muchos grupos para lograr objetivos comunes."
                        )
                    )
                    h2("Comunidades y Cultura")
                    p("""
            Cuando las costumbres, la cultura, el lugar donde vivimos y los sentimientos nos unen, formamos una comunidad.
            En estas comunidades compartimos ideas, tradiciones y formas de vida.
            """.trimIndent()
                    )
                    h2("La Idea de Aristóteles sobre la Sociabilidad Humana")
                    p("""
            Aristóteles, un filósofo antiguo, ya decía que las personas son seres sociales por naturaleza.
            Él nos llamó “zoon politikón”, que significa “animal político”, porque vivimos en sociedad y usamos el lenguaje para comunicarnos.
            También dijo que si alguien no vive en sociedad, es como una bestia o un dios, porque todos necesitamos de los demás.
            """.trimIndent()
                    )
                    p("""
            Ser social es una parte fundamental de ser humano. Desde tiempos antiguos, vivimos y crecemos en grupos y sociedades.
            Esto nos ayuda a satisfacer nuestras necesidades, desarrollarnos y compartir nuestra cultura y sentimientos con los demás.
            Aristóteles, un gran filósofo griego, ya había entendido esto hace miles de años, destacando la importancia de vivir en comunidad.
            """.trimIndent()
                    )
                    p()
                    h4("Quieres saber un poco más?")
                    p("Descarga el capítulo del temario en el siguiente link:")
                    link("| Descarga |", "static/documentos/03_sociedad.pdf", target = "_blank")
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Sociedad") {
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
                    image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Sociedad, el Derecho y el Pensamiento Político") {
                        addCssClass("title")
                    }
                    p("""    Las sociedades humanas son grupos grandes de personas donde no solo se transmiten características genéticas,
            sino también cultura, como el idioma, las costumbres y las ideas. Estas sociedades ayudan a formar la identidad
            de un grupo y a alcanzar objetivos en común.""".trimIndent())
                    h2("¿Cómo Funcionan las Sociedades?")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Las sociedades establecen reglas y procedimientos para funcionar mejor.",
                            "Se organizan, eligen líderes, y definen derechos y responsabilidades.",
                            "Todo esto se ve en diferentes grupos, como clubes, escuelas, ciudades, y hasta en el país entero."
                        )
                    )
                    h2("Ejemplos de Organización Social")
                    p("""    Las sociedades antiguas, como Mesopotamia o Egipto, ya tenían formas complejas de organización.
            El Estado de Chile es un ejemplo de una sociedad organizada con reglas y leyes claras.
            """.trimIndent())
                    h2("Diferencias entre Sociedades Simples y Complejas")
                    p("""    En sociedades pequeñas y simples, las reglas suelen ser más sencillas y se basan en normas sociales.
            En sociedades grandes y complejas, se necesitan leyes y normas para manejar la diversidad de personas, intereses
            y creencias.""".trimIndent())
                    h2("¿Qué es una Comunidad?")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Una comunidad es un grupo de personas que comparten cosas en común, como el idioma, las costumbres o el lugar donde viven.",
                            "Las comunidades tienen una identidad propia que las diferencia de la sociedad en general.",
                            "Esta identidad se transmite culturalmente, a veces sin que nos demos cuenta."
                        )
                    )

                    h2("Comunidades Étnicas y Lingüísticas")
                    p("""    Hay comunidades formadas por historia y cultura compartidas, no por una decisión.
            Un ejemplo son las comunidades indígenas en Chile, como los mapuches o los rapa nui.
            """.trimIndent())
                    h2("Relaciones en una Comunidad")
                    p("""    Las relaciones en una comunidad suelen ser fuertes y se basan en tradiciones y costumbres que duran mucho tiempo.
            """.trimIndent())
                    p("""    Las sociedades humanas son grandes grupos de personas con reglas y organizaciones para vivir juntos y alcanzar metas.
            Las comunidades son grupos más pequeños dentro de las sociedades, con identidades y culturas propias. Ambas son importantes
            para entender cómo vivimos y nos relacionamos con los demás.""".trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Normas") {
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
                    }// Título del artículo
                    image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Sociedad, el Derecho y el Pensamiento Político") {addCssClass("title")}
                    p("""    Las sociedades, ya sean simples o complejas, tienen reglas o "normas" que guían cómo nos comportamos.
                            Estas normas nos ayudan a saber qué está bien y qué está mal, y si no las seguimos, generalmente hay consecuencias.""".trimIndent()
                    )
                    h2("Normas en Sociedades Simples")
                    p("""    En sociedades menos complejas, como las tribus antiguas, las normas no estaban tan separadas de la moral o la religión.
                             Estas sociedades también tenían instituciones fuertes para proteger cosas importantes como la vida y la propiedad.""".trimIndent()
                    )
                    h2("Normas en Sociedades Modernas")
                    p("""    En las sociedades actuales, el derecho, la moral y la religión son más independientes entre sí.
                            El derecho moderno tiene reglas claras y específicas, establecidas por leyes como la Constitución.
                            Estas reglas son obligatorias y si alguien no las cumple, hay consecuencias legales.""".trimIndent()
                    )
                    h2("Tipos de Normas")
                    p("""    Norma Moral (Interna):""".trimIndent())
                    listTag(
                        ListType.UL,
                        listOf(
                            "Se trata de seguir tus propias reglas o principios.",
                            "Lo importante aquí es por qué actúas de cierta manera, no solo lo que haces."
                            )
                    )
                    p("""    Norma de Trato Social (Moral Social):""".trimIndent())
                    listTag(
                        ListType.UL,
                        listOf(
                            "Estas son las costumbres que la sociedad considera correctas.",
                            "A diferencia de la norma moral interna, estas pueden ser impuestas por la sociedad y no dependen de tus motivaciones personales."
                        )
                    )
                    p("""    Norma Jurídica:""".trimIndent())
                    listTag(
                        ListType.UL,
                        listOf(
                            "Las normas jurídicas son las leyes establecidas por el Estado.",
                            "Son obligatorias para todos y si no se cumplen, hay sanciones legales.",
                            "Estas normas cambian más rápido que las morales o religiosas y son resueltas por tribunales de justicia si hay problemas."
                        )
                    )
                    p("""    Las normas de la sociedad son reglas que nos dicen cómo debemos comportarnos en la sociedad.
                            En las sociedades simples, estas normas están más ligadas a la moral y la religión, mientras que en las sociedades modernas,
                            el derecho tiene sus propias reglas claras y separadas de la moral y la religión. Estas reglas ayudan a mantener el orden y la justicia en la sociedad.""".trimIndent()
                    )
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Derechos") {
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
                    }// Título del artículo
                    image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Sociedad, el Derecho y el Pensamiento Político") {addCssClass("title")}
                    p("""    El "Derecho" es una palabra con muchos significados y se refiere a las reglas y normas que una sociedad sigue
                            para vivir en orden. Viene del latín "directum", que significa algo que sigue una regla o ley.""".trimIndent()
                    )
                    h2("¿Qué es el Derecho?")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Es un sistema que regula cómo las personas se comportan en sociedad.",
                            "Se basa en la idea de justicia y certeza legal.",
                            "Ayuda a resolver conflictos y puede aplicarse forzosamente, es decir, se deben seguir sus reglas."
                        )
                    )
                    h2("Evolución del Derecho")
                    p("""    Antes, el Derecho estaba muy mezclado con la tradición, la religión y las costumbres.
                            Con el tiempo, se crearon leyes escritas y procedimientos más claros.""".trimIndent()
                    )
                    h2("Tipos de Derecho")
                    h3("""    Derecho Objetivo:""".trimIndent())
                    p("""    Es el conjunto de todas las normas y leyes que existen en una sociedad.""".trimIndent())
                    h3("""    Derecho Subjetivo:""".trimIndent())
                    p("""    Son los derechos específicos que cada persona tiene, como el derecho a la educación o a la libertad.""".trimIndent())
                    h2("Origen de las Normas Jurídicas")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Las 'Fuentes del Derecho' explican de dónde vienen las leyes.",
                            "Pueden surgir por necesidades del pueblo, cambios políticos o económicos, entre otros.",
                            "Las leyes se crean a través de procesos formales, como el Congreso o el Presidente."
                        )
                    )
                    h2("Clasificación del Derecho")
                    p("""    El Derecho se puede dividir de muchas formas, como Derecho Público y Derecho Privado.""".trimIndent()
                    )
                    h3("""    Derecho Público:""".trimIndent())
                    p("""    Regula la actividad del Estado y las relaciones entre las personas y el Estado.""".trimIndent())
                    h3("""    Derecho Privado:""".trimIndent())
                    p("""    Regula las relaciones entre particulares.""".trimIndent())
                    h2("Derecho Internacional")
                    p("""    Regula las relaciones entre países y protege los derechos humanos a nivel internacional.
            Incluye áreas como el Derecho Internacional Público, Privado, de los Derechos Humanos y Humanitario.
            """.trimIndent()
                    )
                    p("""    El Derecho es un conjunto de normas y reglas que ayudan a mantener el orden y la justicia en la sociedad.
            Ha evolucionado desde estar mezclado con la religión y las costumbres a tener sistemas legales claros y definidos.
            El Derecho se divide en varias áreas, cada una con sus propias reglas y procedimientos, que regulan diferentes
            aspectos de la vida y las relaciones entre personas, organizaciones y países.
            """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Politica") {
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
                    }// Título del artículo
                    image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Sociedad, el Derecho y el Pensamiento Político") {addCssClass("title")}
                    p("""    La política es una palabra que proviene del término griego "polis", que significa ciudad, y se refiere a la actividad y el conjunto de decisiones que se toman en una sociedad organizada, como un país o una comunidad, para regular la convivencia de sus miembros. En otras palabras, la política se encarga de cómo se gobierna una sociedad y cómo se toman las decisiones que afectan a todos. Es como las reglas y acuerdos que seguimos en nuestra casa o en la escuela, pero a nivel de todo un país o región.""".trimIndent()
                    )
                    p("""    Hablar de política es largo y complejo, pero intentaremos resumir los puntos importantes que han influenciado en alguna forma a Chile y Latinoamérica.""".trimIndent()
                    )
                    h2("1. Racionalismo y Pensamiento Contractualista")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Racionalismo: Una época en la que los filósofos dejaron de centrarse en Dios y empezaron a analizar la naturaleza humana.",
                            "Thomas Hobbes: Pensaba que los humanos eran agresivos por naturaleza y que necesitaban un Contrato Social para vivir en paz, dando su poder a un rey con autoridad absoluta.",
                            "John Locke: No estaba de acuerdo con Hobbes sobre la naturaleza humana. Creía en un Contrato Social que limitara el poder del rey por medio de leyes hechas por la gente.",
                            "Charles de Montesquieu: Aportó a la idea de Locke, proponiendo separar el poder del Estado en legislativo, ejecutivo y judicial.",
                            "Jean-Jacques Rousseau: Promovió la Democracia Directa, donde el gobierno debe seguir la voluntad del pueblo sin intermediarios."
                        )
                    )
                    h2("2. Conservadurismo y Liberalismo Post-Revoluciones Liberal-Burguesas")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Conservadurismo: Lamentaba la pérdida del poder de la monarquía y quería mantener las tradiciones y el 'estado natural de las cosas'.",
                            "Liberalismo: Enfatizaba los derechos individuales y la limitación del poder del monarca, conduciendo a la creación del Estado Liberal."
                        )
                    )

                    h2("3. La Cuestión Social y el Pensamiento Socialista")
                    p("""    Socialismo: Surgió por preocupaciones sobre injusticias sociales causadas por la industrialización. Karl Marx y Friedrich Engels analizaron estas injusticias y propusieron un cambio de sistema para evitar la explotación de los trabajadores.""".trimIndent()
                    )
                    h2("4. Estado de Bienestar Bismarckiano")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Otto Von Bismarck: Implementó un sistema de Protección Social para mejorar las condiciones de los trabajadores mientras reprimía los movimientos obreros."
                        )
                    )
                    h2("5. La Gran Depresión y el Pensamiento Keynesiano")
                    p("""    John Maynard Keynes: Propuso la intervención del Estado en la economía para evitar crisis económicas y promover el empleo.""".trimIndent()
                    )
                    h2("6. Fascismo, Populismo y Desarrollismo")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Fascismo y Populismo: Respondieron a la crisis económica mundial con políticas que mezclaban el control social y económico.",
                            "Desarrollismo y CEPALismo: Se enfocaron en promover el desarrollo económico y social, en especial en América Latina, destacando la necesidad de reformas políticas y económicas."
                        )
                    )
                    h2("7. La Alianza para el Progreso y el Pensamiento Social-Cristiano")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Alianza para el Progreso: Un programa de apoyo económico de EE.UU. para América Latina, buscando estabilidad política y debilitar movimientos revolucionarios.",
                            "Pensamiento Social-Cristiano: La Iglesia Católica promovió reformas sociales y económicas para combatir la pobreza y mejorar las condiciones de vida en América Latina."
                        )
                    )
                    h2("8. El Agotamiento del Modelo Keynesiano y el Pensamiento Neoliberal")
                    listTag(
                        ListType.UL,
                        listOf(
                            "Neoliberalismo: Surgió como una respuesta al fracaso del modelo keynesiano, promoviendo menos intervención del Estado en la economía y favoreciendo a las élites económicas."
                        )
                    )
                    p("""    En resumen, desde el Racionalismo hasta el Neoliberalismo, el pensamiento político y filosófico ha pasado por muchas transformaciones. Estos cambios reflejan cómo los filósofos y políticos han intentado entender y mejorar la sociedad, ya sea a través de teorías sobre la naturaleza humana, sistemas políticos, o economías. Cada uno de estos movimientos ha dejado su marca en la historia y ha influenciado la forma en que vivimos hoy.""".trimIndent()
                    )
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
                    // Título del artículo
                    image(src = "static/banner_sociedad.png", alt = "La Sociedad, el Derecho y el Pensamiento Político").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }

                    h1("La Sociedad, el Derecho y el Pensamiento Político") {
                        addCssClass("title")
                    }
                    p("Prueba lo aprendido con este mini-juego")
                    p("Prueba las letras y encuentra las frases.")
                    iframe(src = "https://wordwall.net/es/embed/c3bfbbb7e99a43a3b4ff45b1b22bdb50?themeId=49&templateId=46&fontStackId=0") {
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