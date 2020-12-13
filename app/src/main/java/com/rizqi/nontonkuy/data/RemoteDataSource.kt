package com.rizqi.nontonkuy.data

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.remote.ApiResponse
import com.rizqi.nontonkuy.utils.EspressoIdlingResource
import com.rizqi.nontonkuy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {
  private val handler = Handler(Looper.getMainLooper())

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

  fun getMovies(): LiveData<ApiResponse<List<Movie>>> {
    EspressoIdlingResource.increment()
    val resultMovies = MutableLiveData<ApiResponse<List<Movie>>>()
    handler.postDelayed(
      {
        resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
        EspressoIdlingResource.decrement()
      }, SERVICE_LATENCY_IN_MILLIS
    )
    return resultMovies
  }

  fun getTvs(): LiveData<ApiResponse<List<Tv>>> {
    EspressoIdlingResource.increment()
    val resultTvs = MutableLiveData<ApiResponse<List<Tv>>>()
    handler.postDelayed(
      {
        resultTvs.value = ApiResponse.success(jsonHelper.loadTvs())
        EspressoIdlingResource.decrement()
      }, SERVICE_LATENCY_IN_MILLIS
    )
    return resultTvs
  }

}

