<!-- # R2KApp -->
[![Banner](https://repository-images.githubusercontent.com/725254872/668d9791-0620-42d2-aebc-e0d031692e31)](https://github.com/CarlosAlfaroP/R2KApp)

**R2K: El Derecho a Saber: la WebApp**  
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
## Descripción

Este proyecto proporciona una estructura para una aplicación web utilizando la tecnología de Kotlin/JS junto a KVision.
La estructura permitirá la creación de una plataforma educativa que podrá ser desplegada para libre uso.

## Tabla de Contenidos
- [Características](#características)
- [Características Técnicas](#características-tecnicas)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contribución](#contribución)
- [Licencia](#licencia)

## Características

El proyecto utiliza Kotlin para la creación de una aplicación educativa. 
El fin es que proporcione a estudiantes de todas las edades un acceso sencillo, interactivo y enriquecedor 
a contenidos relacionados con formación cívica, promoviendo el aprendizaje y la comprensión de los principios 
democráticos, los derechos humanos, la ciudadanía y el funcionamiento del gobierno en Chile.

En una primera versión se utiliza la estructura base propuesta en [KVision](https://kvision.gitbook.io/kvision-guide/), 
añadiendo la navegación básica y manejo de usuarios usando [Supabase-kt](https://github.com/supabase-community/supabase-kt).

## Características Técnicas

- Estructura básica para aplicaciones multiplataforma en Kotlin.
- Proyecto omite llaves de Base de Datos, se debe generar y acoplar a nuevos proyectos.
- Un único código base para la lógica frontend-backend.
- Clases implementadas de navegación (bottom-side menu)

## Requisitos

- Android Gradle Plugin (AGP) [Versión 8.2.0-alpha12]
- Kotlin [Versión 1.9.10]
- Gradle [Versión 8.4]
- IntelliJ IDEA [Versión 2023.2.2 (Community Edition) Build #IC-232.9921.47]
- Oracle OpenJDK [Versión 17.0.6] (Recomendado para compilación) 
- Kotlin Multiplatform Client for Supabase. [Versión 2.0.4] (Recomendado)
- KVision, Object oriented web framework for Kotlin/JS. [Versión 7.3.1] (Recomendado)
## Instalación

Para comenzar a trabajar con este proyecto, sigue los siguientes pasos:

1. **Instalar Entorno de Desarrollo**:

   Antes de importar el proyecto en tu entorno de desarrollo, asegúrate de tener un entorno configurado que cumpla con los requisitos y recomendaciones mencionados en la sección de "Requisitos". Esto puede incluir la instalación de IntelliJ IDEA, Gradle y Oracle OpenJDK 17.0.6, entre otros.

2. **Clonar el Repositorio**:

   Utiliza el comando Git para clonar el repositorio en tu máquina local o utiliza la interfaz del framework.

3. **Importar el Proyecto en IntelliJ IDEA**:

   Para importar el proyecto en IntelliJ IDEA, sigue estos pasos:

    - Abre IntelliJ IDEA.

    - Selecciona "File" -> "Open" y busca la carpeta del proyecto.

    - IntelliJ IDEA detectará automáticamente la configuración del proyecto y configurará las rutas de compilación.

Ahora estarás listo para trabajar en el proyecto en tu entorno de desarrollo local.

## Uso

Este proyecto proporciona una estructura lista para la compilación en diversas plataformas. A continuación, se describen los pasos para utilizarlo:

1. **Estructura del Proyecto**:

    - El proyecto consta de un solo módulo `src`: Contiene la lógica compartida.
2. **Compilación**:

   Para compilar el proyecto, asegúrate de cumplir con los requisitos especificados en la sección de "Requisitos". Luego, sigue estos pasos:

    - Abre el proyecto en IntelliJ IDEA (o tu entorno de desarrollo preferido).

    - Configura las rutas de compilación y ejecución para cada módulo correspondiente a la plataforma que deseas compilar.

    - Ejecuta la compilación en tu entorno de desarrollo.

3. **Artefactos para Uso**:

   Después de la compilación, se generarán artefactos específicos para la distribución.

4. **Uso Web**:

    - Si deseas utilizar la versión de desarrollo web de la aplicación, ejecutar `gradlew run -t`.


Ten en cuenta que estos son pasos generales, y la configuración específica puede variar según tu proyecto y las herramientas que utilices. 

## Contribución

Este proyecto es el resultado del esfuerzo y la colaboración de los siguientes contribuyentes:

- Alumnos de Ingeniería Informática en UNIACC:
   - Carlos Alfaro Palma
   - Susana Saravia Medina
   - Maximiliano Arancibia Cares

Si deseas contribuir a este proyecto, no dudes en ponerte en contacto con los contribuyentes mencionados.

## Licencia

Este proyecto se distribuye bajo una licencia de código abierto y se encuentra en constante desarrollo. Consulta la licencia específica en el archivo "LICENSE" adjunto al proyecto.
