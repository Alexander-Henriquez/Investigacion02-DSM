# Investigacion02-DSM
#Link video Explicacion y Funcionamiento
# https://drive.google.com/file/d/1HoT1YmW-3mNaVaugf0zuwMD5MOhqejs7/view?usp=sharing
# Proyecto Android con Retrofit y Kotlin

Este proyecto Android en Kotlin utiliza Retrofit para conectarse a una API pública y mostrar los datos obtenidos en un `RecyclerView`. También implementa manejo de errores con `Snackbar` para una experiencia de usuario amigable.

## Características Principales

1. **Consumo de API**: Utilización de Retrofit y Gson para conectarse a una API pública y obtener datos JSON.
2. **Interfaz de Usuario**: Uso de `RecyclerView` para mostrar la lista de resultados.
3. **Manejo de Errores**: Implementación de `Snackbar` para mostrar mensajes claros en caso de errores de red o respuestas fallidas.
4. **Manejo de Llamadas Asíncronas**: Uso de corutinas de Kotlin para manejar llamadas a la API de manera asíncrona.
5. **Funcionalidad de Reintento**: El usuario puede reintentar una solicitud fallida directamente desde el `Snackbar`.
