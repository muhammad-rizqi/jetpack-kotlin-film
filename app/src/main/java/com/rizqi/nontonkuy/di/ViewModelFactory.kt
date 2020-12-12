package com.rizqi.nontonkuy.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizqi.nontonkuy.data.repo.Repository
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
    when {
      modelClass.isAssignableFrom(MainViewModel::class.java) -> {
        return MainViewModel(repository) as T
      }
      else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
    }

  }
}