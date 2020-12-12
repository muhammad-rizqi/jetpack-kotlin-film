package com.rizqi.nontonkuy.ui.movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.data.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movie: Movie

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)


        movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE) as Movie

        bindToView(movie)
    }


    private fun bindToView (movie: Movie) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
            .into(movie_poster)

        movie_name.text = movie.original_title
        movie_date.text = movie.release_date
        movie_overview.text = movie.overview
        movie_vote.text = movie.vote_average.toString()
        title = movie.original_title
    }
}