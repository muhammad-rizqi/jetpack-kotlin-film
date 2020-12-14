package com.rizqi.nontonkuy.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.utils.AppExecutors
import com.rizqi.nontonkuy.utils.LiveDataTestUtil
import com.rizqi.nontonkuy.utils.PagedListUtil
import com.rizqi.nontonkuy.vo.Resource
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class RepositoryTest {

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  private val remote = mock(RemoteDataSource::class.java)
  private val local = mock(LocalDataSource::class.java)
  private val appExecutors = mock(AppExecutors::class.java)

  private val repository = FakeRepository(remote, local, appExecutors)

  private val services = WebServices()
  private val movieResponses = services.getMovies()
  private val movieId = movieResponses[0].id

  private val tvResponses = services.getTvs()
  private val tvId = tvResponses[0].id


  @Test
  fun getMovies() {
    val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
    `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
    repository.getMovies()

    val entities = Resource.success(PagedListUtil.mockPagedList(services.getMovies()))
    verify(local).getAllMovies()
    assertNotNull(entities.data)
    assertEquals(movieResponses.size.toLong(), entities.data?.size?.toLong())
  }

  @Test
  fun getBookmarkedMovies() {
    val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
    `when`(local.getBookmarkedMovies()).thenReturn(dataSourceFactory)
    repository.getBookmarkedMovies()

    val entities = Resource.success(PagedListUtil.mockPagedList(services.getMovies()))
    verify(local).getBookmarkedMovies()
    assertNotNull(entities)
    assertEquals(movieResponses.size.toLong(), entities.data?.size?.toLong())
  }


  @Test
  fun getMovieById() {
    val dummyEntity = MutableLiveData<Movie>()
    dummyEntity.value = services.getMovies()[0]
    `when`(local.getMovieById(movieId)).thenReturn(dummyEntity)

    val entities = LiveDataTestUtil.getValue(repository.getMovieById(movieId))
    verify(local).getMovieById(movieId)
    assertNotNull(entities.data)
    assertNotNull(entities.data?.original_title)
    assertEquals(movieResponses[0].original_title, entities.data?.original_title)
  }


  @Test
  fun getTvs() {
    val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Tv>
    `when`(local.getAllTvs()).thenReturn(dataSourceFactory)
    repository.getTvs()

    val entities = Resource.success(PagedListUtil.mockPagedList(services.getTvs()))
    verify(local).getAllTvs()
    assertNotNull(entities.data)
    assertEquals(movieResponses.size.toLong(), entities.data?.size?.toLong())
  }

  @Test
  fun getBookmarkedTvs() {
    val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Tv>
    `when`(local.getBookmarkedTvs()).thenReturn(dataSourceFactory)
    repository.getBookmarkedTvs()

    val entities = Resource.success(PagedListUtil.mockPagedList(services.getTvs()))
    verify(local).getBookmarkedTvs()
    assertNotNull(entities)
    assertEquals(tvResponses.size.toLong(), entities.data?.size?.toLong())
  }


  @Test
  fun getTvById() {
    val dummyEntity = MutableLiveData<Tv>()
    dummyEntity.value = services.getTvs()[0]
    `when`(local.getTvById(tvId)).thenReturn(dummyEntity)

    val entities = LiveDataTestUtil.getValue(repository.getTvById(tvId))
    verify(local).getTvById(tvId)
    assertNotNull(entities.data)
    assertNotNull(entities.data?.name)
    assertEquals(tvResponses[0].name, entities.data?.name)
  }
}