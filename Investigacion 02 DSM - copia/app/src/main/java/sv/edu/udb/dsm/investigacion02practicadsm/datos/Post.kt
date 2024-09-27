package sv.edu.udb.dsm.investigacion02practicadsm.datos

//data class Post(
//    val userId: Int,
//    val id: Int,
//    val title: String,
//    val body: String
//)

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String,
    val imageUrl: String
)

