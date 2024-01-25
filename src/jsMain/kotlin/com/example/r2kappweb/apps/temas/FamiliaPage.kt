package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.*
import io.kvision.table.*
import io.kvision.utils.perc
import io.kvision.utils.px
import kotlinx.browser.window

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
                    p(
                        """    La idea “familia” (del latín famīlia) no tiene una definición unívoca, es un vocablo empleado para designar a grupos de personas que viven juntos, unidos, en general, por relaciones de parentesco o de carácter afectivo.
    """.trimIndent()
                    )
                    p(
                        """    La familia es el núcleo fundamental de nuestras sociedades, proporcionando amor, apoyo y un sentido de comunidad. Este artículo explora los distintos aspectos de la vida familiar, desde los desafíos que enfrenta hasta la importancia del amor y el apoyo mutuo.
""".trimIndent()
                    )
                    h2("Vivir en sociedad")
                    p(
                        """    Vivir en sociedad es un rasgo que define al ser humano. En los grupos nómades, los primeros niveles de sociabilidad se encuentran en grupos familiares extendidos, bandas o clanes, hasta llegar a las grandes sociedades, donde la familia sigue teniendo importancia.
    """.trimIndent()
                    )
                    h2("Desafíos y Apoyo Legal para las Familias")
                    p(
                        """    En muchas partes del mundo, las familias enfrentan desafíos como la falta de vivienda o el acceso limitado a la educación. Las leyes internacionales y locales buscan abordar estos desafíos, ofreciendo apoyo a través de programas de asistencia y educación. Esto muestra cómo las comunidades y gobiernos trabajan juntos para asegurar el bienestar de todas las familias.
""".trimIndent()
                    )
                    h2("El Amor y el Apoyo en la Familia")
                    p(
                        """    El corazón de cada familia es el amor y el apoyo mutuo. Las familias comparten tradiciones, celebraciones y se ayudan en los momentos difíciles. Esta unión y cuidado mutuo son fundamentales para el desarrollo y la felicidad de sus miembros, especialmente de los niños. Estas interacciones fortalecen los lazos familiares y contribuyen a la creación de recuerdos valiosos.
""".trimIndent()
                    )
                    p()
                    image(src = "static/artuk_sorprendido.png").apply {
                        maxWidth = 100.perc
                        width = 200.px
                        height = 200.px
                        enablePopover(
                            PopoverOptions(
                                title = ("Artúk:"),
                                content = "Sigue mirando el contenido en las otras pestañas. " +
                                        "Es importante saber de la familia.",
                            )
                        )
                        onClick {
                            this@tab.showPopover()
                            window.setTimeout({ hidePopover() }, 5000)
                        }
                    }
                    h2("La familia como pilar de la sociedad")
                    p("""    Así, la familia, en cualquiera de sus múltiples formas, es reconocida como pilar de la sociedad y es objeto de especial protección por tratados internacionales sobre derechos humanos y por los ordenamientos jurídicos de prácticamente todos los países del mundo.
    """.trimIndent()
                    )
                    p()
                    h4("Quieres saber un poco más?")
                    p("Descarga el capítulo del temario en el siguiente link:")
                    link("| Descarga |", "static/documentos/02_familia.pdf", target = "_blank")
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab("Protección") {
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
                    h1("La familia y la sociedad") { addCssClass("title") }

                    h2("Protección de la familia")
                    p(
                        """    En muchos países, tanto los niños como las familias tienen derechos especiales. La familia es muy importante en todas partes y se considera como la base de la sociedad.
    """.trimIndent()
                    )
                    h2("¿Qué Tipo de Familia se Protege?")
                    p(
                        """    No solo se protege la familia tradicional (papá, mamá e hijos). Los tratados internacionales no definen un solo tipo de familia. Así, se protegen también otras formas de vivir juntos, como familias con solo un papá o una mamá, o familias que se forman por otros lazos aparte de la sangre.
    """.trimIndent()
                    )
                    h2("La Declaración Universal de Derechos Humanos")
                    p(
                        """    Esta declaración, hecha en 1948, dice que todos merecemos libertad y justicia. En su artículo 16, afirma que hombres y mujeres pueden casarse y tener una familia sin importar su raza, nacionalidad o religión. Además, dice que la familia debe ser protegida por la sociedad y el Estado.
    """.trimIndent()
                    )
                    h2("¿Qué Dice el Código Civil?")
                    p(
                        """    El Código Civil solo da una idea de lo que es una familia en un caso muy específico: cuando se habla de los derechos de usar una casa o lugar para vivir. Según el Código, la familia incluye al esposo o esposa, los hijos, los sirvientes necesarios y cualquier otra persona que dependa económicamente de quien usa la casa.
    """.trimIndent()
                    )
                    div {
                        listTag(
                            ListType.UL,
                            listOf(
                                "El Comité de la Eliminación de la Discriminación contra la Mujer dice que no hay un solo modelo de familia.",
                                "El Comité de los Derechos del Niño reconoce diferentes tipos de familias.",
                                "El Comité de Derechos Humanos dice que el concepto de familia puede cambiar dependiendo del país."
                                // ...otros elementos de la lista
                            )
                        )
                    }
                    h2("La Familia en la Ley de Chile")
                    p(
                        """    En Chile, la Constitución dice que la familia es muy importante para la sociedad, pero no explica exactamente qué es una familia. Esto significa que no hay una definición única de familia en las leyes chilenas.
    """.trimIndent()
                    )
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab("Tipos") {
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
                    h1("La familia y la sociedad") { addCssClass("title") }
                    p(
                        """    Así como existen numerosos conceptos para la expresión “familia”, es posible encontrar también distintos tipos de ellas. Las formas en que se componen las familias es muy variada, pues ella puede estar compuesta por una madre o padre con sus hijos, un tío o tía con sus sobrinos, los abuelos con sus nietos, etc. Así, se formulan las siguientes clasificaciones:
    """.trimIndent()
                    )
                    table(
                        listOf(
                            ("Según su extensión"),
                            ("Según su formación")
                        ),
                        setOf(TableType.BORDERED, TableType.SMALL, TableType.STRIPED, TableType.HOVER),
                        responsiveType = ResponsiveType.RESPONSIVE, tbodyDivider = true
                    ) {
                        row {
                            cell {
                                +""
                                (div(rich = true) {
                                    listTag(
                                        ListType.UL,
                                        listOf(
                                            "<b>Familia extensa:</b> aquella constituida por los progenitores, los hijos, los parientes por consanguinidad (tanto en línea recta como colateral) y, si existe matrimonio, los parientes por afinidad. Un reconocimiento a este tipo de familia lo encontramos en el artículo 815 del Código Civil.",
                                            "<b>Familia nuclear:</b>   aquella constituida por los progenitores y los hijos que viven con ellos.",
                                            "<b>Familia monoparental:</b> aquella constituida por un solo progenitor y sus hijos.",
                                            "<b>Familia ensamblada o reconstituida:</b> aquella constituida por los progenitores, sus hijos comunes y los hijos que tengan fruto de una unión anterior con otra pareja."
                                        ),
                                        rich = true
                                    )
                                })
                            }
                            cell {
                                div {
                                    listTag(
                                        ListType.UL,
                                        listOf(
                                            "<b>Familia matrimonial:</b> aquella que tiene su origen en el matrimonio.",
                                            "<b>Familia no matrimonial o natural:</b> aquella que tiene su origen en una unión no matrimonial y cuyo fundamento puede ser sentimental, sexual o de procreación.",
                                            "<b>Familia adoptiva:</b> aquella que se origina con una sentencia judicial que declara a una persona como hijo adoptivo de otro, pasando a formar familia."
                                        ),
                                        rich = true
                                    )
                                }
                            }
                        }
                    }
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab("Matrimonio") {
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
                    h1("La familia y la sociedad") { addCssClass("title") }
                    h2("El Matrimonio en Chile")
                    p("""    El matrimonio en Chile ha sido siempre muy importante. Antes se consideraba más como una tradición religiosa, pero con el tiempo, las leyes han ido cambiando eso.
    """.trimIndent())

                    h2("Matrimonio en el Pasado")
                    p("""    Hasta el siglo XIX, la Iglesia Católica controlaba todo sobre el matrimonio en Chile. Esto significaba que el matrimonio era siempre religioso y no se podía terminar (indisoluble). La primera Ley de Matrimonio Civil, que cambió esto, fue en 1884.
    """.trimIndent())

                    h2("Matrimonio Hoy")
                    p("""    Ahora, el matrimonio está descrito en el Código Civil y en la Ley de Matrimonio Civil. El Código Civil dice que el matrimonio es un contrato entre un hombre y una mujer para vivir juntos, tener hijos y ayudarse mutuamente. La Ley de Matrimonio Civil habla sobre cómo casarse, cómo separarse y cómo terminar un matrimonio.
    """.trimIndent())

                    h2("¿Qué Necesitas para Casarte?")
                    ul {
                        li("Ser hombre y mujer (porque el matrimonio en Chile es entre sexos opuestos).")
                        li("Consentimiento (estar de acuerdo y querer casarte).")
                        li("Celebrarlo ante un oficial del Registro Civil o ratificarlo si se hace en una iglesia.")
                    }

                    h2("Otros Detalles Importantes")
                    ul {
                        li("El matrimonio debe ser entre dos personas (no se permite tener más de un esposo o esposa).")
                        li("No es necesario tener hijos.")
                        li("Hay reglas especiales si alguien se va a casar y está muy enfermo o cerca de morir.")
                    }

                    h2("Requisitos Legales")
                    ul {
                        li("Tienes que tener una cierta edad y ser capaz de tomar esta decisión.")
                        li("No puedes estar ya casado con otra persona.")
                        li("No puedes casarte con ciertos familiares (como tus padres o tus hijos).")
                    }


                    h2("¿Qué Pasa Después de Casarte?")
                    p("""    Una vez casados, hay reglas sobre cómo deben tratarse y cuidarse entre sí. Estas incluyen ser fieles, ayudarse económicamente y vivir juntos. Si no se cumplen, puede haber consecuencias, como el divorcio.
    """.trimIndent())

                    h2("Tipos de Matrimonio en Cuanto a Bienes")
                    p("""    En Chile, hay diferentes maneras de manejar los bienes y el dinero en un matrimonio:    """.trimIndent())
                    ul {
                        li("Sociedad conyugal: Se comparten los bienes.")
                        li("Separación de bienes: Cada uno maneja sus bienes por separado.")
                        li("Participación en los gananciales: Se comparten las ganancias obtenidas durante el matrimonio.")
                    }
                    h2("Separación y Divorcio")
                    p("""    A veces, los matrimonios no funcionan y las parejas deciden separarse o divorciarse. Hay diferentes maneras de hacerlo, dependiendo de la situación.
    """.trimIndent())

                    p()
                    p("""    El matrimonio en Chile ha cambiado mucho a lo largo del tiempo, pasando de una tradición religiosa a una institución más regulada por la ley. Hay reglas específicas sobre cómo casarse, cómo deben tratarse los esposos y cómo manejar sus bienes. También hay maneras de terminar un matrimonio si las cosas no funcionan.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab("Union Civil") {
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
                    h1("La familia y la sociedad") { addCssClass("title") }
                    h2("Acuerdo de Unión")
                    p("""    En Chile, el Acuerdo de Unión Civil (AUC) comenzó en 2015. Es como un contrato entre dos personas que viven juntas, ya sean del mismo sexo o de sexos diferentes. Al hacer este acuerdo, obtienen algunos derechos y deberes.
    """.trimIndent())
                    h2("¿Por Qué se Creó el AUC?")
                    p("""    Antes, las personas que vivían juntas sin estar casadas no tenían muchos derechos. El AUC se creó para ayudar a estas parejas, tanto heterosexuales como homosexuales, dándoles protección legal.
    """.trimIndent())
                    h2("¿Qué Cambios Trajo el AUC?")
                    p("""    El AUC refleja cómo ha cambiado la sociedad en Chile y sigue lo que dicen los tratados internacionales. Por ejemplo, da derechos a las parejas homosexuales y protege sus relaciones.
    """.trimIndent())
                    h2("Características Principales del AUC")
                    ul {
                        li("Es un contrato con derechos y deberes, pero no exige cosas como la fidelidad.")
                        li("Tiene formalidades legales.")
                        li("Crea un tipo de parentesco con la familia de la pareja.")
                        li("Puede ser entre un hombre y una mujer o entre personas del mismo sexo.")
                    }
                    h2("Efectos Prácticos del AUC")
                    ul {
                        li("Permite que una persona sea dependiente de salud de su pareja.")
                        li("Da derecho a una pensión de sobrevivencia.")
                        li("Considera a la pareja como víctima en ciertos casos legales.")
                        li("En una unión heterosexual, los hijos nacidos se consideran hijos de ambos.")
                    }
                    h2("Requisitos para el AUC")
                    ul {
                        li("Ser mayor de edad y poder manejar tus bienes.")
                        li("No estar casado o en otro AUC.")
                        li("Celebrarlo ante el Registro Civil.")
                    }
                    h2("Deberes y Derechos en el AUC")
                    ul {
                        li("Deben ayudarse económicamente.")
                        li("Deben cuidarse mutuamente.")
                        li("Tienen el derecho y deber de vivir juntos, a menos que haya una razón importante para no hacerlo.")
                    }
                    h2("Cómo se Manejan los Bienes en el AUC")
                    p("""    Por defecto, cada persona mantiene sus bienes separados. Pero pueden elegir compartirlos si así lo deciden.
    """.trimIndent())
                    h2("Cómo Termina el AUC")
                    ul {
                        li("Puede terminar por la muerte de uno de los convivientes.")
                        li("Si uno de ellos desaparece y se confirma legalmente su muerte.")
                        li("Si deciden casarse.")
                        li("Si ambos acuerdan terminarlo.")
                        li("Si uno de ellos decide terminarlo.")
                    }
                    p("""    El Acuerdo de Unión Civil en Chile permite a las parejas, ya sean del mismo sexo o no, tener una relación reconocida legalmente con ciertos derechos y deberes, como el apoyo económico y el cuidado mutuo. Es una forma de reconocer y proteger diferentes tipos de relaciones amorosas en la sociedad actual.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab("Mini-Juego") {
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
                    h1("La familia y la sociedad") { addCssClass("title") }
                    p("Prueba lo aprendido con este mini-juego")
                    p("Arrastra las palabras y haz coincidir con su significado")
                    iframe(src = "https://wordwall.net/es/embed/3ea7cc2183ae4d3b8ab7b4ddd728ee81?themeId=48&templateId=10&fontStackId=12") {
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