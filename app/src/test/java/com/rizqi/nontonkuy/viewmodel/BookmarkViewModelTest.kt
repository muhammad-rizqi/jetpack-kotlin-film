package com.rizqi.nontonkuy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv
import com.rizqi.nontonkuy.data.repo.Repository
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {
  private lateinit var viewModel: BookmarkViewModel

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  @Mock
  private lateinit var repository: Repository

  @Mock
  private lateinit var observer: Observer<PagedList<Movie>>

  @Mock
  private lateinit var observerTv: Observer<PagedList<Tv>>

  @Mock
  private lateinit var pagedList: PagedList<Movie>

  @Mock
  private lateinit var pagedListTv: PagedList<Tv>

  @Before
  fun setUp() {
    viewModel = BookmarkViewModel(repository)
  }

  @Test
  fun getMovieBookmark() {
    val dummyMovies = pagedList
    `when`(dummyMovies.size).thenReturn(20)
    val movies = MutableLiveData<PagedList<Movie>>()
    movies.value = dummyMovies

    `when`(repository.getBookmarkedMovies()).thenReturn(movies)
    val entities = viewModel.getMovieBookmarks().value
    verify(repository).getBookmarkedMovies()
    assertNotNull(entities)
    assertEquals(20, entities?.size)

    viewModel.getMovieBookmarks().observeForever(observer)
    verify(observer).onChanged(dummyMovies)
  }

  @Test
  fun getTvBookmark() {
    val dummyTv = pagedListTv
    `when`(dummyTv.size).thenReturn(20)
    val tvs = MutableLiveData<PagedList<Tv>>()
    tvs.value = dummyTv

    `when`(repository.getBookmarkedTvs()).thenReturn(tvs)
    val entities = viewModel.getTvBookmarks().value
    verify(repository).getBookmarkedTvs()
    assertNotNull(entities)
    assertEquals(20, entities?.size)

    viewModel.getTvBookmarks().observeForever(observerTv)
    verify(observerTv).onChanged(dummyTv)
  }
}