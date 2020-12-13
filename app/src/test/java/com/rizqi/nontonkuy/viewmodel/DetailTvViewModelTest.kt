package com.rizqi.nontonkuy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rizqi.nontonkuy.data.WebServices
import com.rizqi.nontonkuy.data.model.Tv
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
class DetailTvViewModelTest {
  private lateinit var viewModel: DetailTvViewModel
  private val dummyTv = WebServices().getTvs()[0]
  private val id = dummyTv.id

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  @Mock
  private lateinit var repository: Repository

  @Mock
  private lateinit var observer: Observer<Resource<Tv>>

  @Before
  fun setUp() {
    viewModel = DetailTvViewModel(repository)
    viewModel.setSelectedTv(id)
  }

  @Test
  fun getMovieById() {
    val dummyTvById = Resource.success(WebServices().getTvs()[0])
    val tv = MutableLiveData<Resource<Tv>>()
    tv.value = dummyTvById

    `when`(repository.getTvById(id)).thenReturn(tv)

    viewModel.tv.observeForever(observer)

    verify(observer).onChanged(dummyTvById)
  }
}