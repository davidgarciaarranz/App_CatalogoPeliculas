package com.multimedia.ej11

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.multimedia.ej11.databinding.ActivityMainBinding
import model.MovieDbClient
import model.Movies
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){
            isGranted -> val message = if(isGranted){
                "Permiso concedido"
            }else{
                "Permiso denegado"
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter(emptyList()) { movie ->
            //Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
            navigateTo(movie)
        }
        binding.recycle.adapter = moviesAdapter

        //solicitud al us para conceder permiso a la localización
        requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)

        //hilo paralelo al principal
        //  para comprobar que hay comunicación con la api
        thread {
            val apikey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apikey)
            val body = popularMovies.execute().body()
    //lo de aquí se ejecuta en el hilo principal
            runOnUiThread {
                if (body!=null){
                    //Log.d("MainActivity", "Movie count: ${body.results.size}")
                    moviesAdapter.movies = body.results
                    moviesAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun navigateTo(movie: Movies) {
        val intent = Intent(this, DetaillsActivity::class.java)
        intent.putExtra(DetaillsActivity.EXTRA_MOVIE,movie)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("destruir", "se ha destruido")
    }
}