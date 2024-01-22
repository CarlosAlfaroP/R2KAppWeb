package com.example.r2kappweb.apps.temas

import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.VPanel
import io.kvision.panel.tab
import io.kvision.panel.tabPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class LegislativoPage (private val onBack: () -> Unit) : VPanel() {
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
                    image(src = "static/banner_legislativo.png", alt = "El Poder Legislativo").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Poder Legislativo") { addCssClass("title") }
                    p("""    El Poder Legislativo en Chile tiene una estructura bicameral, es decir, está compuesto por el Senado y la Cámara de Diputados.
    """.trimIndent())

                    h3("1. Estructura Bicameral")
                    ul {
                        li("Congreso Nacional: Compuesto por el Senado y la Cámara de Diputados.")
                        li("Senado: Aumentó a 43 senadores, llegará a 50 en 2022.")
                        li("Cámara de Diputados: Aumentó a 155 miembros.")
                    }

                    h3("2. Objetivos Principales")
                    ul {
                        li("Representar a la ciudadanía.")
                        li("Concurrir en la formación de leyes con el Presidente de la República.")
                        li("Fiscalizar actos del Gobierno (especialmente la Cámara de Diputados).")
                    }

                    h3("3. Historia y Descentralización")
                    ul {
                        li("Primer Congreso en 1811, unicameral en Santiago.")
                        li("Establecimiento del Senado en 1812.")
                        li("Congreso bicameral desde 1822.")
                        li("Actualmente, la sede del Congreso Nacional está en Valparaíso, con sesiones y reuniones también en Santiago y otras regiones.")
                    }

                    h3("4. Atribuciones Exclusivas del Congreso Nacional")
                    ul {
                        li("Aprobar o desechar tratados internacionales presentados por el Presidente.")
                        li("Pronunciarse sobre estados de excepción constitucional.")
                        li("Elegir al Presidente de la República en ciertos casos de vacancia.")
                    }

                    h3("5. Proceso de Formación de la Ley")
                    ul {
                        li("Iniciativa: Puede originarse en cualquier cámara o por mensaje del Presidente.")
                        li("Tramitación: Inicio en la Cámara de Origen y revisión en la Cámara Revisora.")
                        li("Discusión y Aprobación: Análisis y votación en cada cámara.")
                        li("Comisiones Mixtas: En caso de desacuerdos entre cámaras.")
                        li("Vetos y Observaciones del Presidente: Pueden ser aditivos, sustitutivos o supresivos.")
                        li("Promulgación y Publicación: Tras aprobación presidencial, el proyecto se convierte en ley y se publica en el Diario Oficial.")
                    }

                    h3("6. Urgencias")
                    p("""    El Presidente puede solicitar urgencia para la tramitación de un proyecto de ley.
    """.trimIndent())

                    h3("7. Control de Constitucionalidad")
                    p("""    Realizado por el Tribunal Constitucional en proyectos de ley.
    """.trimIndent())

                    h3("8. Participación Internacional")
                    p("""    Los parlamentarios participan en organizaciones parlamentarias internacionales y misiones oficiales.
    """.trimIndent())

                    p("""    El Poder Legislativo en Chile, representado por el Senado y la Cámara de Diputados, desempeña un papel crucial en la formación de leyes, representación ciudadana y fiscalización del gobierno, con un proceso legislativo detallado. Además, se destaca su participación en el ámbito internacional y el esfuerzo por la descentralización con la ubicación del Congreso en Valparaíso.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("La Cámaras") {
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
                    image(src = "static/banner_legislativo.png", alt = "El Poder Legislativo").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Poder Legislativo") { addCssClass("title") }
                    h2("El Senado")
                    h3("1. Composición Actual y Futura")
                    ul {
                        li("Actualmente compuesto por 43 Senadores, aumentará a 50 en 2021.")
                        li("La renovación se realiza alternativamente por regiones pares e impares, más la Región Metropolitana.")
                    }
                    h3("2. Requisitos para ser Senador")
                    ul {
                        li("Ser ciudadano con derecho a sufragio.")
                        li("Tener al menos 35 años de edad.")
                        li("Haber cursado la educación media o su equivalente.")
                    }
                    h3("3. Duración en el Cargo")
                    ul {
                        li("Los Senadores ejercen por un período de ocho años.")
                        li("El Senado se renueva parcialmente cada cuatro años.")
                    }
                    h3("4. Funciones del Senado")
                    ul {
                        li("Ejerce la función legislativa junto con la Cámara de Diputados.")
                        li("Tiene atribuciones exclusivas como conocer acusaciones constitucionales y decidir sobre acciones judiciales contra ministros.")
                        li("Participa en la elección de ministros del Tribunal Constitucional y del Contralor General de la República.")
                        li("Su Presidente forma parte del Consejo de Seguridad Nacional.")
                    }
                    h2("La Cámara de Diputados")
                    h3("1. Composición")
                    ul {
                        li("Integrada por 155 miembros, elegidos en 28 distritos electorales.")
                    }
                    h3("2. Requisitos para ser Diputado")
                    ul {
                        li("Ser ciudadano con derecho a sufragio.")
                        li("Tener al menos 21 años de edad.")
                        li("Haber cursado la educación media o su equivalente.")
                        li("Residir en la región del distrito electoral por al menos dos años previos a la elección.")
                    }
                    h3("3. Duración en el Cargo")
                    ul {
                        li("Los Diputados son elegidos por un período de cuatro años.")
                        li("La Cámara se renueva completamente en cada elección.")
                    }
                    h3("4. Funciones de la Cámara de Diputados")
                    ul {
                        li("Participa en la legislación.")
                        li("Ejerce atribuciones exclusivas de fiscalización de los actos del Gobierno.")
                        li("Puede formar comisiones investigadoras y declarar sobre acusaciones constitucionales contra altas autoridades.")
                    }
                    p("""    El Senado y la Cámara de Diputados de Chile desempeñan roles fundamentales en el proceso legislativo y en la fiscalización del Gobierno. Ambas cámaras tienen sus propias características y atribuciones exclusivas que garantizan un equilibrio en el ejercicio del poder legislativo. Con la reforma de la Ley Nº 20.840, se evidencia una adaptación y modernización en la composición del Congreso Nacional, reflejando un esfuerzo por una representación más equitativa y actualizada de la ciudadanía.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("Las votaciones") {
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
                    image(src = "static/banner_legislativo.png", alt = "El Poder Legislativo").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Poder Legislativo") { addCssClass("title") }
                    h2("Actuación Legislativa y Fiscalizadora de Senadores y Diputados en Chile: Métodos de Votación y Pareos")

                    p("""    Los Senadores y Diputados en Chile realizan su labor legislativa y de fiscalización a través de decisiones y acuerdos, fundamentados principalmente en el voto. Sin embargo, en asuntos que les afecten directa o personalmente, así como a sus familiares cercanos, no tienen derecho a voto.
    """.trimIndent())

                    h3("Tipos de Votaciones en el Congreso Chileno")
                    h4("1. Votaciones Públicas y Secretas")
                    ul {
                        li("La norma general son las votaciones públicas.")
                        li("Las votaciones secretas se realizan mediante balotas o papeletas.")
                    }
                    h4("2. Votaciones en la Cámara de Diputados")
                    ul {
                        li("Nominativas: Se pueden ejecutar mediante votación electrónica, cédulas, papeletas o voto oral, registrado en actas.")
                        li("Económicas: No requieren justificación del voto. Pueden realizarse por levantamiento de manos, votación electrónica, entre otros métodos.")
                    }
                    h4("3. Votaciones en el Senado")
                    ul {
                        li("Individuales: Los Senadores votan uno a uno, en orden de asiento o alfabético, ya sea oralmente o mediante sistema electrónico, manteniendo el carácter público de la votación.")
                    }

                    h3("Los Pareos en el Congreso")
                    p("""    Definición: Los pareos son acuerdos escritos entre congresistas de partidos opuestos para abstenerse de votar en ciertas situaciones, especialmente en caso de ausencia de uno de ellos.
            Regulación: Están regulados en los artículos 167 del Reglamento de la Cámara de Diputados y el artículo 9° del Reglamento del Senado.
    """.trimIndent())

                    p("""    Los métodos de votación y los pareos son mecanismos esenciales para el funcionamiento democrático y eficiente del Congreso en Chile. Permiten una actuación legislativa transparente y regulada, asegurando la representación adecuada de los distintos sectores y opiniones dentro del poder legislativo. Estos procesos son fundamentales para mantener la integridad y la eficacia del sistema parlamentario chileno.
    """.trimIndent())
                    p()
                    button("Volver", style = ButtonStyle.DARK).onClick {
                        onBack()
                    }
                }
            }
            tab ("La Ley") {
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
                    image(src = "static/banner_legislativo.png", alt = "El Poder Legislativo").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Poder Legislativo") { addCssClass("title") }
                    h2("Concepto y Tipos de Leyes en el Ordenamiento Jurídico Chileno")

                    p("""    El jurista francés Marcel Planiol define la ley como una "regla social obligatoria, establecida permanentemente por la autoridad pública y sancionada por la fuerza". Esta definición implica la existencia de una voluntad superior que manda y otra inferior que obedece, establecida por autoridades públicas (Congreso Nacional y Presidente de la República) y reforzada por sanciones, ya sean preventivas o represivas.
    """.trimIndent())

                    h3("1. Tipos de Normas Jurídicas en Chile")
                    ul {
                        li("Constitución Política: Ley fundamental del Estado.")
                        li("Leyes Propiamente Tales: Normas de carácter general, abstracto y obligatorio.")
                        li("Reglamento: Norma general dictada por un órgano distinto del legislativo.")
                    }

                    h3("2. Tipos de Leyes y sus Quórum")
                    ul {
                        li("Leyes Interpretativas de la Constitución: Precisan o explican aspectos de la Constitución.")
                        li("Leyes Orgánicas Constitucionales: Complementan la Constitución en materias específicas.")
                        li("Leyes de Quórum Calificado: Tratan materias específicas señaladas en la Constitución.")
                        li("Leyes Ordinarias o Comunes: Regulan aspectos variados de la vida social.")
                        li("Decretos con Fuerza de Ley: Emitidos por el Presidente bajo delegación del Parlamento.")
                        li("Decretos Leyes: Normas con rango de ley dictadas por gobiernos de facto.")
                        li("Tratados Internacionales: Acuerdos formales entre Estados o entidades internacionales.")
                    }

                    h3("Rol del Congreso en Tratados Internacionales")
                    p("""    El Presidente de la República gestiona las relaciones internacionales de Chile. El Congreso Nacional aprueba o rechaza los tratados internacionales presentados por el Presidente. Los tratados sobre derechos fundamentales que Chile ha ratificado constituyen un límite a la soberanía nacional.
    """.trimIndent())

                    p("""    Este marco legal y su estructura son cruciales para el funcionamiento del sistema jurídico en Chile, asegurando que las leyes se creen, interpreten y apliquen de manera ordenada y conforme a la Constitución y a los principios democráticos.
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
                    image(src = "static/banner_legislativo.png", alt = "El Poder Legislativo").apply {
                        width = 100.perc
                        maxHeight = 350.px
                        maxWidth = 600.px
                    }
                    h1("El Poder Legislativo") { addCssClass("title") }
                    p("Prueba lo aprendido con este mini-juego")
                    iframe(src = "https://wordwall.net/es/embed/ab6a7322bc364268a5229d9517acdc52?themeId=23&templateId=49&fontStackId=0") {
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