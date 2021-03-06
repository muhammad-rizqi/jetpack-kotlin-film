package com.rizqi.nontonkuy.ui.movies

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.rizqi.nontonkuy.R
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.di.ViewModelFactory
import com.rizqi.nontonkuy.viewmodel.DetailMovieViewModel
import com.rizqi.nontonkuy.vo.Status
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

  private lateinit var movie: Movie

  companion object {
    const val EXTRA_MOVIE = "extra_movie"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_detail)
    val factory = ViewModelFactory.getInstance(this)
    val viewModel = ViewModelProvider(this, factory).get(DetailMovieViewModel::class.java)

    movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE) as Movie

    viewModel.setSelectedMovie(movie.id)

    viewModel.movie.observe(this) {
      if (it != null) {
        when (it.status) {
          Status.LOADING -> movieProgressBar?.visibility = View.VISIBLE
          Status.SUCCESS -> if (it.data != null) {
            movieProgressBar?.visibility = View.GONE
            bindToView(it.data)
            val state = it.data.bookmarked
            setBookmarkState(state)
          }
          Status.ERROR -> {
            movieProgressBar?.visibility = View.GONE
            Toast.makeText(
              applicationContext,
              "Terjadi kesalahan",
              Toast.LENGTH_SHORT
            ).show()
          }
        }
      }
    }

    movieFloatingActionButton?.setOnClickListener {
      viewModel.setBookmark()
    }

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

  private fun setBookmarkState(state: Boolean) {
    if (state) {
      movieFloatingActionButton?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
    } else {
      movieFloatingActionButton?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
    }
  }
}