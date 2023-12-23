package com.example.r2kappweb.apps

data class Tema(
    val nombre: String,
    val subtitulo: String,
    val descripcion: String,
    val rutaBanner: String
)

val cards = listOf(
    Tema(
        "La Persona y los Derechos Humanos",
        "Derechos y Responsabilidades",
        "Explora los derechos fundamentales del individuo y su papel en la sociedad. Descubre cómo cada individuo es un pilar fundamental en la construcción de una sociedad justa y equitativa, a través de la exploración de los derechos humanos universales.",
        "static/banner_persona.png"),
    Tema(
        "La Familia",
        "Núcleo Fundamental de la Sociedad",
        "Sumérgete en la esencia de la sociedad: la familia. Explora su impacto y relevancia en el desarrollo social y personal.",
        "static/banner_familia.png"
    ),
    Tema(
        "La Sociedad, el Derecho y el Pensamiento Político",
        "Núcleo Fundamental de la Sociedad",
        "Navega por el entramado de la sociedad, el derecho y el pensamiento político, descubriendo cómo moldean nuestra visión del mundo.",
        "static/banner_sociedad.png"
    ),
    Tema(
        "La Democracia y la Ciudadanía",
        "Participación y Gobierno",
        "Adéntrate en el corazón de la democracia y el ejercicio activo de la ciudadanía, comprendiendo su poder en el cambio y la toma de decisiones.",
        "static/banner_democracia.png"
    ),
    Tema(
        "La Constitución",
        "Marco Legal Supremo",
        "Explora el documento que da forma a nuestra nación: la Constitución. Entiende su importancia y su papel en la definición de nuestras leyes y estructura social.",
        "static/banner_constitucion.png"
    ),
    Tema(
        "El Estado",
        "Organización y Función",
        "Descubre la estructura y funciones del Estado, y cómo este organismo complejo interactúa y se relaciona con cada ciudadano.",
        "static/banner_estado.png"
    ),
    Tema(
        "Funciones y Estructura",
        "Subtítulo de Legislativo",
        "Aprende sobre el Poder Legislativo, su estructura y su crucial rol en la creación y modificación de las leyes que rigen nuestra sociedad.",
        "static/banner_legislativo.png"
    )
)
