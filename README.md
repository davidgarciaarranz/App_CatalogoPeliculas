# App Catalogo Películas

## Descripción

Este proyecto consiste en el desarrollo de una aplicación Android que consume la API de **The Movie Database (TMDB)** para mostrar una lista de las películas más populares actualmente. La aplicación permite visualizar los pósters y títulos en una lista principal y acceder a los detalles específicos de cada película al pulsar sobre ella.

Se han implementado patrones modernos de desarrollo en Android, incluyendo la gestión de hilos para peticiones de red, el uso de adaptadores dinámicos y la integración de librerías de terceros para el manejo de imágenes y servicios REST.

## Funcionamiento

* **Listado de Películas:** Uso de `RecyclerView` con un adaptador personalizado (`MoviesAdapter`) para mostrar las películas obtenidas de la API.
* **Consumo de API:** Integración con TMDb mediante `Retrofit` para obtener datos en formato JSON de forma asíncrona.
* **Carga de Imágenes:** Uso de la librería `Glide` para la descarga y renderizado eficiente de las portadas de las películas.
* **Navegación:** Implementación de navegación entre `MainActivity` y `DetaillsActivity` pasando objetos a través de `Intent`.
* **View Binding:** Uso de la funcionalidad View Binding para simplificar la interacción con los elementos de la interfaz de usuario de forma segura.
* **Permisos:** Gestión de permisos en tiempo de ejecución (ejemplo de localización incluido).

## Estructura del proyecto

```text
app/src/main/
├── java/
│   ├── com.multimedia.ej11/
│   │   ├── DetaillsActivity.kt
│   │   ├── MainActivity.kt
│   │   └── MoviesAdapter.kt
│   └── model/
│       ├── MovieBdResult.kt
│       ├── MovieDbClient.kt
│       ├── Movies.kt
│       └── TheMovieDbService.kt
├── res/
│   ├── layout/
│   │   ├── activity_detaills.xml
│   │   ├── activity_main.xml
│   │   └── view_movies_item.xml
│   └── values/
│       ├── api_key.xml
│       ├── strings.xml
│       └── themes.xml
└── AndroidManifest.xml
```

## Tecnologías utilizadas

* **Kotlin:** Lenguaje de programación principal.
* **Android SDK:** Plataforma de desarrollo.
* **Retrofit 2:** Cliente HTTP para el consumo de servicios web REST.
* **Glide:** Librería para carga y caché de imágenes.
* **View Binding:** Para la vinculación de vistas de forma segura.
* **RecyclerView:** Para la visualización de listas de datos complejos.
* **The Movie Database API (TMDb):** Fuente de datos de las películas.

## Autor

Desarrollado por David García.