package com.rizqi.nontonkuy.di

import android.content.Context
import com.rizqi.nontonkuy.data.RemoteDataSource
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.utils.JsonHelper

object Injection {
  fun provideRepository(context: Context): Repository {

    val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

    return Repository.getInstance(remoteDataSource)
  }
}