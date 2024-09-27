package sv.edu.udb.dsm.investigacion02practicadsm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sv.edu.udb.dsm.investigacion02practicadsm.datos.Pokemon // Cambia esto si tu clase se llama diferente


class PostAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PostAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNombre: TextView = view.findViewById(R.id.textViewNombre)
        val textViewUrl: TextView = view.findViewById(R.id.textViewUrl) // Cambia esto si necesitas mostrar la URL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.textViewNombre.text = pokemon.name // Asumiendo que 'name' es la propiedad del Pokémon
        holder.textViewUrl.text = pokemon.url // Mostrar la URL del Pokémon si es necesario
    }

    override fun getItemCount(): Int = pokemonList.size
}
