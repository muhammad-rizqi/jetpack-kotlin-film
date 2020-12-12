package com.rizqi.nontonkuy.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizqi.nontonkuy.data.MainDataSource
import com.rizqi.nontonkuy.data.RemoteDataSource
import com.rizqi.nontonkuy.data.model.Movies
import com.rizqi.nontonkuy.data.model.Tvs

class Repository(private val remoteDataSource: RemoteDataSource) : MainDataSource {
    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData)
            }
    }

    override fun getMovies(): LiveData<Movies> {
        val movies = MutableLiveData<Movies>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(response: Movies) {
                movies.postValue(response)
            }
        })
        return movies
    }

    override fun getTvs(): LiveData<Tvs> {
        val tvs = MutableLiveData<Tvs>()
        remoteDataSource.getTvs(object : RemoteDataSource.LoadTvsCallback {
            override fun onAllTvsReceived(response: Tvs) {
                tvs.postValue(response)
            }
        })
        return tvs
    }

}