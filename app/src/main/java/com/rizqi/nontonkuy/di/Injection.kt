package com.rizqi.nontonkuy.di

import android.content.Context
import com.rizqi.nontonkuy.data.LocalDataSource
import com.rizqi.nontonkuy.data.RemoteDataSource
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.data.room.MainDatabase
import com.rizqi.nontonkuy.utils.AppExecutors
import com.rizqi.nontonkuy.utils.JsonHelper

object Injection {
  fun provideRepository(context: Context): Repository {

    val database = MainDatabase.getInstance(context)

    val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
    val localDataSource = LocalDataSource.getInstance(database.mainDao())
    val appExecutors = AppExecutors()

    return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
  }
}