package com.rizqi.nontonkuy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.vo.Resource

class DetailMovieViewModel(private val repository: Repository) : ViewModel() {
  private val movieId = MutableLiveData<Int>()

  fun setSelectedCourse(id: Int) {
    this.movieId.value = id
  }

  var movie: LiveData<Resource<Movie>> = Transformations.switchMap(movieId) {
    repository.getMovieById(it)
  }

  fun setBookmark() {
    val movieResource = movie.value
    if (movieResource != null) {
      val movieById = movieResource.data

      if (movieById != null) {
        val newState = !movieById.bookmarked
        repository.setMovieBookmark(movieById, newState)
      }
    }
  }
}
