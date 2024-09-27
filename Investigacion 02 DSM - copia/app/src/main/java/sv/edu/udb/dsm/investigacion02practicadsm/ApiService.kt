package sv.edu.udb.dsm.investigacion02practicadsm

import retrofit2.http.GET
import retrofit2.http.Query
import sv.edu.udb.dsm.investigacion02practicadsm.datos.PokemonResponse

interface ApiService {
    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonResponse
}
