package com.puput.mymoviesubdua.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.puput.mymoviesubdua.data.MovieRepository
import com.puput.mymoviesubdua.data.entity.ListTvShowResponse
import com.puput.mymoviesubdua.utils.CatalogueData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<ListTvShowResponse>>


    @Test
    fun getALlTvShow() {
        val dummyTvShow = CatalogueData.generateTvShow()
        val tvShow = MutableLiveData<List<ListTvShowResponse>>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getAllTVShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getAllTvShow()?.value
        verify<MovieRepository>(movieRepository).getAllTVShow()

        assertNotNull(tvShowEntities)
        assertEquals(tvShow.value?.size, tvShowEntities?.size)

        viewModel.getAllTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}