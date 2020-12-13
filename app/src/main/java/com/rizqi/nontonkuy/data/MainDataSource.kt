package com.rizqi.nontonkuy.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.vo.Resource

interface MainDataSource {
  fun getMovies(): LiveData<Resource<PagedList<Movie>>>

  fun getTvs(): LiveData<Resource<PagedList<Tv>>>

  fun getBookmarkedMovies(): LiveData<PagedList<Movie>>

  fun setMovieBookmark(movie: Movie, state: Boolean)

  fun getBookmarkedTvs(): LiveData<PagedList<Tv>>

  fun setTvBookmark(tv: Tv, state: Boolean)

  fun getTvById(tvId : Int): LiveData<Resource<Tv>>

  fun getMovieById(movieId: Int): LiveData<Resource<Movie>>

}