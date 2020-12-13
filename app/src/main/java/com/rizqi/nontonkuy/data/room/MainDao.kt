package com.rizqi.nontonkuy.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv

@Dao
interface MainDao {

  @Query("SELECT * FROM movies")
  fun getMovies(): DataSource.Factory<Int, Movie>


  @Query("SELECT * FROM tvs")
  fun getTvs(): DataSource.Factory<Int, Tv>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertMovies(movies: List<Movie>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertTvs(tvs: List<Tv>)

  @Update
  fun updateMovie(movie: Movie)

  @Update
  fun updateTv(tv: Tv)

  @Query("SELECT * FROM movies where bookmarked = 1")
  fun getBookmarkedMovie(): DataSource.Factory<Int, Movie>

  @Query("SELECT * FROM tvs where bookmarked = 1")
  fun getBookmarkedTv(): DataSource.Factory<Int, Tv>

  @Query("SELECT * FROM movies WHERE id = :movieId")
  fun getMovieById(movieId: Int): LiveData<Movie>

  @Query("SELECT * FROM tvs WHERE id = :tvId")
  fun getTvById(tvId: Int): LiveData<Tv>

}
