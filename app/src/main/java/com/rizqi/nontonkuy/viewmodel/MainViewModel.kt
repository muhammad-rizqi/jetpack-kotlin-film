package com.rizqi.nontonkuy.viewmodel

import androidx.lifecycle.ViewModel
import com.rizqi.nontonkuy.data.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MainViewModel(private val repo: Repository) : ViewModel(), CoroutineScope {


  override val coroutineContext = Job() + Dispatchers.Unconfined



  fun getMovies() = repo.getMovies()

  fun getTvs() = repo.getTvs()
}