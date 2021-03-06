package com.rizqi.nontonkuy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rizqi.nontonkuy.data.WebServices
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.repo.Repository
import com.rizqi.nontonkuy.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
  private lateinit var viewModel: DetailMovieViewModel
  private val dummyMovie = WebServices().getMovies()[0]
  private val id = dummyMovie.id

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  @Mock
  private lateinit var repository: Repository

  @Mock
  private lateinit var observer: Observer<Resource<Movie>>

  @Before
  fun setUp() {
    viewModel = DetailMovieViewModel(repository)
    viewModel.setSelectedMovie(id)
  }

  @Test
  fun getMovieById() {
    val dummyMovieById = Resource.success(WebServices().getMovies()[0])
    val movie = MutableLiveData<Resource<Movie>>()
    movie.value = dummyMovieById

    `when`(repository.getMovieById(id)).thenReturn(movie)

    viewModel.movie.observeForever(observer)

    verify(observer).onChanged(dummyMovieById)
  }
}