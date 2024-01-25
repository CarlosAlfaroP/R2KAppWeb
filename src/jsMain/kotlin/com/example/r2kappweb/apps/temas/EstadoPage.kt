package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class EstadoPage (private val onBack: () -> Unit) : VPanel() {
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
                    image(src = "static/banner_estado.png", alt = "El Estado y sus poderes").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Estado y sus poderes") { addCssClass("title") }
                    h2("¿Qué es un Estado?")
                    p("""    Imagina un gran equipo o club, pero mucho más complejo. Es una forma de organización que agrupa a las personas en un lugar y regula cómo viven juntas.
            Tiene reglas y líderes (como un gobierno) y trabaja en un área específica (como un país).
    """.trimIndent())

                    h2("Definiciones a Través del Tiempo")
                    ul {
                        li("Muchos pensadores han intentado explicar qué es un Estado. Carré de Malberg, por ejemplo, dijo en 1988 que es una comunidad en un lugar específico, con reglas propias y poder sobre su gente.")
                        li("Esta idea proviene de Europa en el siglo XVII, después de unos acuerdos llamados “Paz de Westfalia”.")
                        li("Estos acuerdos ayudaron a formar los países como los conocemos hoy, con fronteras y gobiernos propios.")
                    }

                    h2("El Estado en la Historia")
                    p("""    Antes, las personas se agrupaban en familias, clanes o tribus. Pero con el tiempo, estas agrupaciones crecieron y se convirtieron en Estados.
            Los Estados se han convertido en los principales actores en el mundo, especialmente en temas de política internacional.
    """.trimIndent())

                    h2("Ejemplos Modernos de Estados")
                    p("""    Un ejemplo interesante es la Unión Europea, que es como un gran equipo formado por varios países de Europa. Están trabajando juntos de una manera nueva y diferente, compartiendo algunas reglas y trabajando por objetivos comunes.
    """.trimIndent())
                    p()
                    h4("Quieres saber un poco más?")
                    p("Descarga el capítulo del temario en el siguiente link:")
                    link("| Descarga |", "static/documentos/06_estado.pdf", target = "_blank")
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Origen ") {
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
                    image(src = "static/banner_estado.png", alt = "El Estado y sus poderes").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Estado y sus poderes") { addCssClass("title") }
                    h2("Modelos de Estado: Evolución y Conceptos Clave")
                    p("""    Historia: Antes, los Estados se centraban en figuras poderosas como monarcas (Estados absolutos). Pero ideas de libertad y democracia, como en la Revolución Francesa y la Independencia de EE.UU., cambiaron esto, llevando a Estados más democráticos y constitucionales.
    """.trimIndent())

                    h2("Forma de Estado vs. Forma de Gobierno")
                    ul {
                        li("Forma de Estado: Cómo se distribuye el poder en el país (centralizado o repartido).")
                        li("Forma de Gobierno: Cómo se ejerce el poder y se eligen los gobernantes (presidencial, parlamentario, etc.).")
                    }

                    h2("Tipos de Estados: Simples y Federales")
                    h3("1. Estado Simple o Unitario")
                    ul {
                        li("Poder Centralizado: Un solo centro de poder en la capital.")
                        li("Unidad Normativa: Una sola Constitución para todo el país.")
                        li("Administración Centralizada o Descentralizada: Puede haber organismos locales con cierta autonomía pero bajo el poder central.")
                    }
                    h3("2. Estado Federal")
                    ul {
                        li("Descentralización Política: Poder dividido entre el gobierno central y regiones.")
                        li("Autonomía Regional: Regiones tienen sus propios gobiernos y constituciones, pero subordinadas a una Constitución principal.")
                        li("Doble Estructura: Combina un gobierno central con gobiernos regionales autónomos.")
                        li("Principios Fundamentales: Autonomía administrativa regional y participación en decisiones nacionales.")
                    }

                    h2("Ejemplos en el Mundo")
                    p("""    Estados Unidos (federal, presidencial) vs. Alemania (federal, parlamentario).
            Chile (unitario, presidencial) vs. México (federal, presidencial).
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Elementos ") {
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
                    image(src = "static/banner_estado.png", alt = "El Estado y sus poderes").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Estado y sus poderes") { addCssClass("title") }
                    h2("Elementos Constitutivos del Estado: Población, Territorio y Poder")

                    h3("1. Elemento Humano o Poblacional")
                    ul {
                        li("Concepto: Agrupación de personas en un territorio, incluyendo tanto nacionales como extranjeros.")
                        li("Censo: Herramienta para conocer datos demográficos, realizada por el Instituto Nacional de Estadísticas (INE) en Chile.")
                        li("Nación: Conjunto de personas con características e historia comunes.")
                        li("Nacionalidad: Determinada por la Constitución (ius solis, ius sanguinis, nacionalización).")
                        li("Ciudadanía: Capacidad política para participar en la vida pública, generalmente a través del voto. En Chile, se obtiene a los 18 años y sin condenas a pena aflictiva.")
                    }

                    h3("2. Elemento Territorial")
                    ul {
                        li("Concepto: Espacio geográfico donde el Estado ejerce su soberanía.")
                        li("Territorio Físico de Chile: Delimitado por fronteras con Perú, Bolivia, Argentina, Polo Sur y el Océano Pacífico. Incluye territorio continental, antártico y polinésico.")
                        li("Extensión: 2.006.626 Km² en total, incluyendo territorio continental e insular (756.765 Km²) y Antártica (1.250.000 Km²).")
                        li("Dimensiones: Largo de 4.337 Km (7.670 Km con Antártica); ancho promedio de 180 Km.")
                        li("Composición Territorial: Espacio terrestre, marítimo, aéreo y jurídico.")
                    }

                    h3("3. Elemento Poder")
                    ul {
                        li("Definición: Capacidad de dirigir y normar la sociedad hacia objetivos comunes.")
                        li("Características: Originario, autónomo e independiente. Coactivo, centralizado y territorialmente delimitado.")
                        li("Soberanía: Reside en la nación y se ejerce a través de elecciones y plebiscitos.")
                        li("División de Poderes: Ejecutivo, Legislativo y Judicial, cada uno con funciones distintas.")
                        li("Fin del Estado: Buscar el bien común, garantizando orden, justicia, bienestar y paz.")
                    }

                    h2("Estado de Derecho")
                    ul {
                        li("Definición: El Estado se somete a un ordenamiento jurídico que garantiza derechos y libertades.")
                        li("Principios: Imperio de la Ley, División de Poderes, Legalidad de la Administración, Protección de Derechos Humanos.")
                    }

                    p("""    El Estado es una entidad compleja que combina población, territorio y poder en un marco de respeto a la ley y protección de los derechos fundamentales de sus ciudadanos.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Sistemas políticos") {
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
                    image(src = "static/banner_estado.png", alt = "El Estado y sus poderes").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Estado y sus poderes") { addCssClass("title") }
                    h2("Sistemas Políticos y Poderes del Estado en Chile")

                    h3("1. Sistemas Políticos")
                    p("""    Definición: Conjunto que incluye forma de gobierno, organización de poderes públicos, estructuras socioeconómicas, tradiciones y costumbres.
    """.trimIndent())
                    ul {
                        li("Regímenes Autocráticos:")
                        ul {
                            li("Totalitario: Partido único con ideología totalizante, control total sobre la vida de las personas, no se toleran minorías discrepantes.")
                            li("Autoritario: Pluralismo político limitado, basado en mentalidades y costumbres, con un grupo dominante.")
                        }
                        li("Regímenes Democráticos: Caracterizados por la división de poder, elecciones libres y transparentes, respeto a derechos humanos y valores democráticos.")
                    }

                    h3("2. Poderes del Estado en Chile")
                    p("""    Poder Ejecutivo:
    """.trimIndent())
                    ul {
                        li("Presidente de la República: Jefe de Estado y Gobierno, con funciones en gobierno, administración, legislativa, judicial y económica.")
                        li("Atribuciones del Presidente: Formación de leyes, potestad reglamentaria, convocatoria a plebiscitos, entre otras.")
                        li("Responsabilidad y Requisitos para ser Presidente: Posibilidad de acusación constitucional, ser chileno, mayor de 35 años y ciudadano con derecho a sufragio. Mandato presidencial de cuatro años sin reelección inmediata.")
                    }
                    p("""    Poder Legislativo:
    """.trimIndent())
                    ul {
                        li("Congreso Nacional: Compuesto por el Senado y la Cámara de Diputados.")
                        li("Funciones: Creación de leyes, control del Ejecutivo y tramitación de acusaciones constitucionales.")
                    }
                    p("""    Poder Judicial:
    """.trimIndent())
                    ul {
                        li("Misión: Administrar justicia, resolver causas civiles y criminales, hacer ejecutar lo juzgado.")
                        li("Estructura: Corte Suprema, Cortes de Apelaciones y diversos juzgados.")
                        li("Principios Básicos: Imparcialidad, independencia, legalidad, inamovilidad, inexcusabilidad y responsabilidad de los jueces.")
                    }

                    p("""    En resumen, el sistema político en Chile se caracteriza por su naturaleza democrática, con un poder ejecutivo liderado por un presidente, un poder legislativo bicameral y un poder judicial independiente, cada uno con funciones y responsabilidades específicas dentro del marco de la Constitución y las leyes del país.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Otros órganos del Estado ") {
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
                    image(src = "static/banner_estado.png", alt = "El Estado y sus poderes").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Estado y sus poderes") { addCssClass("title") }
                    h2("Sistemas Políticos y Poderes del Estado en Chile")

                    h3("1. Ministerio Público")
                    ul {
                        li("Función: Dirigir la investigación de delitos, ejercer acción penal pública y proteger a víctimas y testigos.")
                        li("Estructura: Fiscalía Nacional, 18 fiscalías regionales, fiscalías locales.")
                        li("Colaboración: Trabaja con Carabineros de Chile, Policía de Investigaciones, entre otros.")
                    }

                    h3("2. Tribunal Constitucional")
                    ul {
                        li("Función: Garantizar la supremacía constitucional.")
                        li("Atribuciones: Control de constitucionalidad de leyes y otros actos.")
                        li("Composición: Diez miembros designados por distintas entidades.")
                        li("Duración: Nueve años, renovables cada tres años.")
                    }

                    h3("3. Tribunal Calificador de Elecciones")
                    ul {
                        li("Función: Gestionar procesos electorales nacionales y plebiscitos.")
                        li("Composición: Miembros de la Corte Suprema y otros.")
                        li("Duración: Cuatro años.")
                    }

                    h3("4. Contraloría General de la República")
                    p("""    Función: Controlar actos administrativos y fiscalizar gastos públicos.
    """.trimIndent())

                    h3("5. Fuerzas Armadas y Fuerzas de Orden y Seguridad")
                    p("""    Incluye el Ejército, Armada, Fuerza Aérea, Carabineros de Chile y Policía de Investigaciones.
    """.trimIndent())

                    h3("6. Consejo de Seguridad Nacional")
                    ul {
                        li("Función: Asesorar al Presidente en seguridad nacional.")
                        li("Composición: Incluye al Presidente, presidentes de las cámaras y otros.")
                    }

                    h3("7. Banco Central")
                    ul {
                        li("Función: Velar por estabilidad monetaria y pagos internos y externos.")
                        li("Composición: Cinco miembros nombrados por el Presidente con acuerdo del Senado.")
                        li("Duración: Diez años.")
                    }

                    h3("8. Gobierno y Administración Interior del Estado")
                    p("""    Incluye la división territorial en regiones, provincias y comunas.
    """.trimIndent())

                    h3("9. Gobierno y Administración Provincial")
                    p("""    Incluye gobernaciones y otros órganos desconcentrados del intendente.
    """.trimIndent())

                    h3("10. Administración Comunal")
                    ul {
                        li("Municipalidades: Alcalde y concejo municipal.")
                        li("Función: Satisfacer necesidades locales y autonomía en finanzas.")
                        li("Duración de Cargos: Cuatro años.")
                    }

                    h3("11. Territorios Especiales")
                    p("""    Incluye Isla de Pascua y Archipiélago Juan Fernández, entre otros.
    """.trimIndent())

                    p("""    En resumen, Chile cuenta con una variedad de órganos estatales especializados que abarcan desde la administración de justicia y elecciones hasta la seguridad nacional y la gestión monetaria, incluyendo entidades descentralizadas a nivel regional, provincial y comunal.
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
                    image(src = "static/banner_democracia.png", alt = "La Constitución de Chile").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("La Constitución de Chile") {
                        addCssClass("title")
                    }
                    p("Prueba lo aprendido con este mini-juego")
                    p("Prueba las letras y encuentra las frases.")
                    iframe(src = "https://wordwall.net/es/embed/3e69096a6adf4084b8a643d147149b14?themeId=21&templateId=35&fontStackId=0") {
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