package com.rizqi.nontonkuy.data

import androidx.lifecycle.LiveData
import com.rizqi.nontonkuy.data.model.Movies
import com.rizqi.nontonkuy.data.model.Tvs

interface MainDataSource {
  fun getMovies(): LiveData<Movies>
  fun getTvs(): LiveData<Tvs>
}