package sv.edu.udb.dsm.investigacion02practicadsm

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import retrofit2.HttpException
import sv.edu.udb.dsm.investigacion02practicadsm.datos.Pokemon
import com.google.android.material.snackbar.Snackbar
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pokemonAdapter: PostAdapter
    private lateinit var progressBar: ProgressBar
    private val pokemonList = mutableListOf<Pokemon>()
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pokemonAdapter = PostAdapter(pokemonList)
        recyclerView.adapter = pokemonAdapter

        progressBar = findViewById(R.id.progressBar)

        val buttonRefresh: Button = findViewById(R.id.buttonRefresh)
        obtenerPokemons()

        buttonRefresh.setOnClickListener {
            obtenerPokemons()
        }
    }

    private fun obtenerPokemons() {
        progressBar.visibility = View.VISIBLE // Mostrar el ProgressBar

        lifecycleScope.launch {
            Log.d(TAG, "Iniciando solicitud GET para obtener pokemons...")
            mostrarSnackbar("Iniciando solicitud GET para obtener pokemons...")
            try {
                val response = RetrofitInstance.api.getPokemons(0, 20)
                Log.d(TAG, "Solicitud GET exitosa, número de pokemons recibidos: ${response.results.size}")
                pokemonList.clear()
                pokemonList.addAll(response.results)
                pokemonAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE // Ocultar el ProgressBar después de cargar los datos
            } catch (e: IOException) {
                Log.e(TAG, "Error de red")
                mostrarSnackbar("Error de red")
                progressBar.visibility = View.GONE
            } catch (e: HttpException) {
                Log.e(TAG, "Error de red: ")
                mostrarSnackbar("Error de red:")
                progressBar.visibility = View.GONE
            } catch (e: Exception) {
                Log.e(TAG, "Error al obtener los datos: ")
                mostrarSnackbar("Error al obtener los datos: ")
                progressBar.visibility = View.GONE
            }
        }
    }
    private fun mostrarSnackbar(mensaje: String) {
        Snackbar.make(findViewById(android.R.id.content), mensaje, Snackbar.LENGTH_LONG)
            .setAction("") {
                obtenerPokemons()
            }.show()
    }
}

