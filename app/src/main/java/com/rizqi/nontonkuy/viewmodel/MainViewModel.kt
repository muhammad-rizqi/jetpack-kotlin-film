package com.rizqi.nontonkuy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.vo.Resource

class MainViewModel(private val repo: Repository) : ViewModel() {

  fun getMovies() : LiveData<Resource<PagedList<Movie>>> = repo.getMovies()

  fun getTvs() : LiveData<Resource<PagedList<Tv>>> = repo.getTvs()
}