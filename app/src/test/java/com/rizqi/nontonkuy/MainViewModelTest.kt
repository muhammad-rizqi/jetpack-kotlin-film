package com.rizqi.nontonkuy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rizqi.nontonkuy.data.WebServices
import com.rizqi.nontonkuy.data.model.Movies
import com.rizqi.nontonkuy.data.model.Tvs
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.viewmodel.MainViewModel
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
  private lateinit var observerMovies: Observer<Movies>


  @Mock
  private lateinit var observerTvs: Observer<Tvs>

  @Before
  fun setUp() {
    Dispatchers.setMain(Dispatchers.Unconfined)
    mainViewModel = MainViewModel(repository)
  }

  @Test
  fun getMovies() {
    val dummyMovie = WebServices().getMovies()
    val movie = MutableLiveData<Movies>()
    movie.value = dummyMovie

    `when`(repository.getMovies()).thenReturn(movie)
    val movieEntities = mainViewModel.getMovies().value
    verify(repository).getMovies()
    assertNotNull(movieEntities)
    assertEquals(20, movieEntities?.results?.size)

    mainViewModel.getMovies().observeForever(observerMovies)
    verify(observerMovies).onChanged(dummyMovie)
  }

  @Test
  fun getTvs() {
    val dummyTvs = WebServices().getTvs()
    val tvs = MutableLiveData<Tvs>()
    tvs.value = dummyTvs

    `when`(repository.getTvs()).thenReturn(tvs)
    val tvsEntities = mainViewModel.getTvs().value
    verify(repository).getTvs()
    assertNotNull(tvsEntities)
    assertEquals(20, tvsEntities?.results?.size)

    mainViewModel.getTvs().observeForever(observerTvs)
    verify(observerTvs).onChanged(dummyTvs)
  }

}