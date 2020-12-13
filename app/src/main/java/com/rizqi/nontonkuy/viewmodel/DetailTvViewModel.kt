package com.rizqi.nontonkuy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.vo.Resource

class DetailTvViewModel(private val repository: Repository) : ViewModel() {
  private val tvId = MutableLiveData<Int>()

  fun setSelectedTv(id: Int) {
    this.tvId.value = id
  }

  var tv: LiveData<Resource<Tv>> = Transformations.switchMap(tvId) {
    repository.getTvById(it)
  }

  fun setBookmark() {
    val resource = tv.value
    if (resource != null) {
      val byId = resource.data

      if (byId != null) {
        val newState = !byId.bookmarked
        repository.setTvBookmark(byId, newState)
      }
    }
  }
}
