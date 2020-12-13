package com.rizqi.nontonkuy.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.room.MainDao

class LocalDataSource private constructor(private val mMainDao: MainDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mainDao: MainDao): LocalDataSource {
            if (INSTANCE == null) {
                INSTANCE = LocalDataSource(mainDao)
            }
            return INSTANCE as LocalDataSource
        }
    }

    fun getAllMovies(): DataSource.Factory<Int, Movie> = mMainDao.getMovies()

    fun getAllTvs(): DataSource.Factory<Int, Tv> = mMainDao.getTvs()

    fun getBookmarkedMovies(): DataSource.Factory<Int, Movie> = mMainDao.getBookmarkedMovie()

    fun getBookmarkedTvs(): DataSource.Factory<Int, Tv> = mMainDao.getBookmarkedTv()

    fun insertMovies(movies: List<Movie>) = mMainDao.insertMovies(movies)

    fun insertTvs(tvs: List<Tv>) = mMainDao.insertTvs(tvs)

    fun setMovieBookmarked (movie: Movie, newState: Boolean) {
        movie.bookmarked = newState
        mMainDao.updateMovie(movie)
    }

    fun setTvBookmarked (tv: Tv, newState: Boolean) {
        tv.bookmarked = newState
        mMainDao.updateTv(tv)
    }

    fun getTvById(tvId: Int): LiveData<Tv> = mMainDao.getTvById(tvId)

    fun getMovieById(movieId: Int): LiveData<Movie> = mMainDao.getMovieById(movieId)
}