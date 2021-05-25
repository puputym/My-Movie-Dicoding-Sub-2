package com.puput.mymoviesubdua.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.puput.mymoviesubdua.data.MovieRepository
import com.puput.mymoviesubdua.data.entity.DetailMovie
import com.puput.mymoviesubdua.data.entity.DetailTVShow
import com.puput.mymoviesubdua.utils.CatalogueData
import org.junit.Assert.assertEquals
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
class DetailMovieActivityViewModelTest {


    private lateinit var viewModel: DetailMovieActivityViewModel
    private val dummymovie = CatalogueData.generateDetailMovie()
    private val dummytvShow = CatalogueData.generateDetailTvShow()
    private val catalogIdMovie = dummymovie.id
    private val catalogIdTvShow = dummytvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var observerMv: Observer<DetailMovie>

    @Mock
    private lateinit var observerTv: Observer<DetailTVShow>


    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieActivityViewModel(movieRepository)
    }

    @Test
    fun getDetailMovie() {

        val movie = MutableLiveData<DetailMovie>()
        movie.value = dummymovie

        `when`(movieRepository.getAllDetailMovie(catalogIdMovie.toString())).thenReturn(movie)
        val movieEntities = viewModel.getDetailMovie(catalogIdMovie.toString())?.value
        verify<MovieRepository>(movieRepository).getAllDetailMovie(catalogIdMovie.toString())

        assertNotNull(movieEntities)
        assertEquals(movie.value!!.id, movieEntities?.id)
        assertEquals(movie.value!!.posterPath, movieEntities?.posterPath)
        assertEquals(movie.value!!.releaseDate, movieEntities?.releaseDate)
        assertEquals(movie.value!!.voteAverage, movieEntities?.voteAverage)
        assertEquals(movie.value!!.overview, movieEntities?.overview)
        assertEquals(movie.value!!.title, movieEntities?.title)
        assertEquals(movie.value!!.runtime, movieEntities?.runtime)


        viewModel.getDetailMovie(catalogIdMovie.toString()).observeForever(observerMv)
        verify(observerMv).onChanged(dummymovie)
    }

    @Test
    fun getDetailTvShow() {
        val tvShow = MutableLiveData<DetailTVShow>()
        tvShow.value = dummytvShow

        `when`(movieRepository.getAllDetailTvShow(catalogIdTvShow.toString())).thenReturn(tvShow)
        val tvEntities = viewModel.getDetailTvShow(catalogIdTvShow.toString())?.value
        verify<MovieRepository>(movieRepository).getAllDetailTvShow(catalogIdTvShow.toString())

        assertNotNull(tvEntities)
        assertEquals(tvShow.value!!.id, tvEntities?.id)
        assertEquals(tvShow.value!!.posterPath, tvEntities?.posterPath)
        assertEquals(tvShow.value!!.overview, tvEntities?.overview)
        assertEquals(tvShow.value!!.firstAirDate, tvEntities?.firstAirDate)
        assertEquals(tvShow.value!!.status, tvEntities?.status)
        assertEquals(tvShow.value!!.name, tvEntities?.name)
        assertEquals(tvShow.value!!.voteAverage, tvEntities?.voteAverage)

        viewModel.getDetailTvShow(catalogIdTvShow.toString()).observeForever(observerTv)
        verify(observerTv).onChanged(dummytvShow)
    }
}