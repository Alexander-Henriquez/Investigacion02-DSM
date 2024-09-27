package sv.edu.udb.dsm.investigacion02practicadsm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    // Crear la instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Crear el servicio de la API
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
