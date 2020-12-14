package com.rizqi.nontonkuy.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.remote.ApiResponse
import com.rizqi.nontonkuy.utils.AppExecutors
import com.rizqi.nontonkuy.vo.Resource

class FakeRepository(
  private val remoteDataSource: RemoteDataSource,
  private val localDataSource: LocalDataSource,
  private val appExecutors: AppExecutors
) : MainDataSource {

  override fun getMovies(): LiveData<Resource<PagedList<Movie>>> {
    return object : NetworkBoundResource<PagedList<Movie>, List<Movie>>(appExecutors) {
      public override fun loadFromDB(): LiveData<PagedList<Movie>> {
        val config = PagedList.Config.Builder()
          .setEnablePlaceholders(false)
          .setInitialLoadSizeHint(4)
          .setPageSize(4)
          .build()
        return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
      }

      override fun shouldFetch(data: PagedList<Movie>?): Boolean =
        data == null || data.isEmpty()

      public override fun createCall(): LiveData<ApiResponse<List<Movie>>> =
        remoteDataSource.getMovies()

      public override fun saveCallResult(data: List<Movie>) {
        localDataSource.insertMovies(data)
      }
    }.asLiveData()
  }


  override fun getTvs(): LiveData<Resource<PagedList<Tv>>> {
    return object : NetworkBoundResource<PagedList<Tv>, List<Tv>>(appExecutors) {
      public override fun loadFromDB(): LiveData<PagedList<Tv>> {
        val config = PagedList.Config.Builder()
          .setEnablePlaceholders(false)
          .setInitialLoadSizeHint(4)
          .setPageSize(4)
          .build()
        return LivePagedListBuilder(localDataSource.getAllTvs(), config).build()
      }

      override fun shouldFetch(data: PagedList<Tv>?): Boolean =
        data == null || data.isEmpty()

      public override fun createCall(): LiveData<ApiResponse<List<Tv>>> =
        remoteDataSource.getTvs()

      public override fun saveCallResult(data: List<Tv>) {
        localDataSource.insertTvs(data)
      }
    }.asLiveData()
  }


  override fun getBookmarkedTvs(): LiveData<PagedList<Tv>> {
    val config = PagedList.Config.Builder()
      .setEnablePlaceholders(false)
      .setInitialLoadSizeHint(4)
      .setPageSize(4)
      .build()
    return LivePagedListBuilder(localDataSource.getBookmarkedTvs(), config).build()
  }

  override fun setMovieBookmark(movie: Movie, state: Boolean) {
    appExecutors.diskIO().execute {
      localDataSource.setMovieBookmarked(movie, state)
    }
  }

  override fun getBookmarkedMovies(): LiveData<PagedList<Movie>> {
    val config = PagedList.Config.Builder()
      .setEnablePlaceholders(false)
      .setInitialLoadSizeHint(4)
      .setPageSize(4)
      .build()
    return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
  }

  override fun setTvBookmark(tv: Tv, state: Boolean) {
    appExecutors.diskIO().execute {
      localDataSource.setTvBookmarked(tv, state)
    }

  }

  override fun getTvById(tvId: Int): LiveData<Resource<Tv>> {
    return object : NetworkBoundResource<Tv, List<Tv>>(appExecutors) {
      override fun loadFromDB(): LiveData<Tv> =
        localDataSource.getTvById(tvId)

      override fun shouldFetch(data: Tv?): Boolean = data == null

      override fun createCall(): LiveData<ApiResponse<List<Tv>>> = remoteDataSource.getTvs()

      override fun saveCallResult(data: List<Tv>) {
        localDataSource.insertTvs(data)
      }
    }.asLiveData()
  }

  override fun getMovieById(movieId: Int): LiveData<Resource<Movie>> {
    return object : NetworkBoundResource<Movie, List<Movie>>(appExecutors) {
      override fun loadFromDB(): LiveData<Movie> =
        localDataSource.getMovieById(movieId)

      override fun shouldFetch(data: Movie?): Boolean = data == null

      override fun createCall(): LiveData<ApiResponse<List<Movie>>> =
        remoteDataSource.getMovies()

      override fun saveCallResult(data: List<Movie>) {
        localDataSource.insertMovies(data)
      }
    }.asLiveData()
  }
}