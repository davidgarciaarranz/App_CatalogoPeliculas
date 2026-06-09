package com.multimedia.ej11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.multimedia.ej11.MoviesAdapter.ViewHolder
import com.multimedia.ej11.databinding.ViewMoviesItemBinding
import model.Movies

/*interface MovieClickedLisener {
    fun onMovieCliced(movies: Movies)
}*/

class MoviesAdapter(var movies: List<Movies>,
                    //private val movieClickedLisener: MovieClickedLisener lo sustituimos por una lamba
                    private val movieClickedLisener: (Movies) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    //crea una nueva vista cuando el recyclerview se lo pide
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bilding = ViewMoviesItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(bilding)
    }

    //actualiza una vista cuando el adapter se lo solicita
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            //movieClickedLisener.onMovieCliced(movies[position])
            movieClickedLisener(movies[position])
        }
    }

    //devuelve el nunero de elementos que tiene el adaptador
    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(private val bilding : ViewMoviesItemBinding) : RecyclerView.ViewHolder(bilding.root){
        fun bind(movie : Movies){
            bilding.title.text = movie.title
            Glide.with(bilding.root.context).load("https://image.tmdb.org/t/p/w185/${movie.poster_path}").into(bilding.cover)
        }
    }
}