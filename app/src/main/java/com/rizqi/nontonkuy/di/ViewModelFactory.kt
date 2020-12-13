package com.rizqi.nontonkuy.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.viewmodel.BookmarkViewModel
import com.rizqi.nontonkuy.viewmodel.DetailMovieViewModel
import com.rizqi.nontonkuy.viewmodel.DetailTvViewModel
import com.rizqi.nontonkuy.viewmodel.MainViewModel

class ViewModelFactory private constructor(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {

  companion object {
    @Volatile
    private var instance: ViewModelFactory? = null

    fun getInstance(context: Context): ViewModelFactory =
      instance ?: synchronized(this) {
        instance ?: ViewModelFactory(Injection.provideRepository(context))
      }
  }

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return when {
      modelClass.isAssignableFrom(MainViewModel::class.java) -> {
        MainViewModel(repository) as T
      }
      modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
        DetailMovieViewModel(repository) as T
      }
      modelClass.isAssignableFrom(DetailTvViewModel::class.java) -> {
        DetailTvViewModel(repository) as T
      }
      modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
        BookmarkViewModel(repository) as T
      }
      else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
    }

  }
}