package com.puput.mymoviesubdua.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.puput.mymoviesubdua.data.remote.RemoteDataSource
import com.puput.mymoviesubdua.utils.CatalogueData
import com.puput.mymoviesubdua.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val fakeRepository = FakeMovieRepository(remote)

    private val movieResponse = CatalogueData.generateMovieData()
    private val tvShowResponse = CatalogueData.generateTvShow()


    private val movieDetailResponse = CatalogueData.generateDetailMovie()
    private val movieId = movieDetailResponse.id

    private val tvShowDetailResponse = CatalogueData.generateDetailTvShow()
    private val tvId = tvShowDetailResponse.id

    @Test
    fun getAllMovie() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.movieCallback)
                    .onAllMovieReceived(movieResponse)
                null
            }.`when`(remote).getMovie(any())
        }

        val movie = LiveDataTestUtil.getValue(fakeRepository.getAllMovie())
        runBlocking {
            verify(remote).getMovie(any())
        }
        assertNotNull(movie)
        assertEquals(movieResponse.size, movie.size)
    }

    @Test
    fun getAllTvShow() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.tvShowCallback)
                    .onAllTvShowReceived(tvShowResponse)
                null
            }.`when`(remote).getTvShow(any())
        }
        val tvShow = LiveDataTestUtil.getValue(fakeRepository.getAllTvShow())
        runBlocking {
            verify(remote).getTvShow(any())
        }
        assertNotNull(tvShow)
        assertEquals(tvShowResponse.size, tvShow.size)
    }

    @Test
    fun getAllDetailMovie() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[1] as RemoteDataSource.detailMovieCallback)
                    .onDetailMovieReceive(movieDetailResponse)
                null
            }.`when`(remote).getDetailMovie(eq(movieId.toString()), any())
        }
        val detilMovie =
            LiveDataTestUtil.getValue(fakeRepository.getDetailMovie(movieId.toString()))
        runBlocking {
            verify(remote).getDetailMovie(eq(movieId.toString()), any())
        }
        assertNotNull(detilMovie)
        assertEquals(movieDetailResponse.id.toString(), detilMovie.id.toString())
    }

    @Test
    fun getAllDetailTvShow() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[1] as RemoteDataSource.detailTvShowCallback)
                    .onDetailTvShowReceived(tvShowDetailResponse)
                null
            }.`when`(remote).getDetailTvShow(eq(tvId.toString()), any())
        }
        val detailtvShow =
            LiveDataTestUtil.getValue(fakeRepository.getDetailTvShow(tvId.toString()))

        runBlocking {
            verify(remote)
                .getDetailTvShow(eq(tvId.toString()), any())
        }
        assertNotNull(detailtvShow)
        assertEquals(tvShowDetailResponse.id.toString(), detailtvShow.id.toString())
    }

}
