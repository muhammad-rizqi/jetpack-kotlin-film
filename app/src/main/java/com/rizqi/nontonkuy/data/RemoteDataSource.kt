package com.rizqi.nontonkuy.data

import android.os.Handler
import com.rizqi.nontonkuy.data.model.Movies
import com.rizqi.nontonkuy.data.model.Tvs
import com.rizqi.nontonkuy.utils.EspressoIdlingResource
import com.rizqi.nontonkuy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
  private val handler = Handler()

  companion object {
    private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

    @Volatile
    private var instance: RemoteDataSource? = null

    fun getInstance(helper: JsonHelper): RemoteDataSource =
      instance ?: synchronized(this) {
        instance
          ?: RemoteDataSource(helper)
      }
  }

  fun getMovies(callback: LoadMoviesCallback) {
    EspressoIdlingResource.increment()
    handler.postDelayed(
      {
        callback.onAllMoviesReceived(jsonHelper.loadMovies())
        EspressoIdlingResource.decrement()
      }, SERVICE_LATENCY_IN_MILLIS
    )
  }

  fun getTvs(callback: LoadTvsCallback) {
    EspressoIdlingResource.increment()
    handler.postDelayed(
      {
        callback.onAllTvsReceived(jsonHelper.loadTvs())
        EspressoIdlingResource.decrement()
      }, SERVICE_LATENCY_IN_MILLIS
    )
  }

  interface LoadMoviesCallback {
    fun onAllMoviesReceived(response: Movies)
  }

  interface LoadTvsCallback {
    fun onAllTvsReceived(response: Tvs)
  }
}

