package com.rizqi.nontonkuy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.viewmodel.MainViewModel
import com.rizqi.nontonkuy.vo.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

  private lateinit var mainViewModel: MainViewModel

  @get:Rule
  var rule: TestRule = InstantTaskExecutorRule()

  @Mock
  private lateinit var repository: Repository

  @Mock
  private lateinit var observerMovies: Observer<Resource<PagedList<Movie>>>

  @Mock
  private lateinit var pagedList: PagedList<Movie>


  @Before
  fun setUp() {
    Dispatchers.setMain(Dispatchers.Unconfined)
    mainViewModel = MainViewModel(repository)
  }

  @Test
  fun getMovies() {
    val dummyMovie = Resource.success(pagedList)
    `when`(dummyMovie.data?.size).thenReturn(20)
    val movie = MutableLiveData<Resource<PagedList<Movie>>>()
    movie.value = dummyMovie

    `when`(repository.getMovies()).thenReturn(movie)
    val movieEntities = mainViewModel.getMovies().value?.data
    verify(repository).getMovies()
    assertNotNull(movieEntities)
    assertEquals(20, movieEntities?.size)

    mainViewModel.getMovies().observeForever(observerMovies)
    verify(observerMovies).onChanged(dummyMovie)

  }

}