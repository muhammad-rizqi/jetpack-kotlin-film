package com.rizqi.nontonkuy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.repo.Repository

class BookmarkViewModel(private val repository: Repository) : ViewModel() {
  fun getMovieBookmarks(): LiveData<PagedList<Movie>> = repository.getBookmarkedMovies()

  fun getTvBookmarks(): LiveData<PagedList<Tv>> = repository.getBookmarkedTvs()

  fun setMovieBookmark(movie: Movie) {
    val newState = !movie.bookmarked
    repository.setMovieBookmark(movie, newState)
  }

  fun setTvBookmark(tv: Tv) {
    val newState = !tv.bookmarked
    repository.setTvBookmark(tv, newState)
  }
}
