package com.multimedia.ej11

import android.os.Build
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.multimedia.ej11.databinding.ActivityDetaillsBinding
import model.Movies

class DetaillsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity::movie"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detaills)

        val binding = ActivityDetaillsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE, Movies::class.java)

        if(movie != null){
            title = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780/${movie.backdrop_path}")
                .into(binding.backdrop)
            binding.Summary.text = movie.overview
            
            bindDetailInfo(binding.DetailInfo, movie)
        }

    }

    private fun bindDetailInfo(detailInfo: TextView, movies: Movies) {
        //detailInfo.text = "Original language: ${movies.original_language}"
        detailInfo.text = buildSpannedString {
            apendInfo(R.string.original_language, movies.original_language)
            apendInfo(R.string.original_title, movies.original_title)
            apendInfo(R.string.release_date, movies.release_date)
            apendInfo(R.string.popularity, movies.popularity.toString())
            apendInfo(R.string.vote_average, movies.vote_average.toString())
//            bold { append(getString(R.string.original_language) + ": ")
//            appendLine(movies.original_language) }
//            bold { append(getString(R.string.original_title) + ": ")
//            appendLine(movies.original_title) }
//            bold { append(getString(R.string.release_date) + ": ")
//            appendLine(movies.release_date) }
//            bold { append(getString(R.string.popularity) + ": ")
//            appendLine(movies.popularity.toString()) }
//            bold { append(getString(R.string.vote_average) + ": ")
//            appendLine(movies.vote_average.toString()) }
        }
    }

    private fun SpannableStringBuilder.apendInfo(stringRes: Int, value: String) {
        bold{
            append(getString(stringRes) + ": ")
        }
        appendLine(value)
    }

}