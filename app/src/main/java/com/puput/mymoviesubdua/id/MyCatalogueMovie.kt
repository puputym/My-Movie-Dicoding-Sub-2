package com.puput.mymoviesubdua.id

import android.app.Application
import com.puput.mymoviesubdua.data.MovieRepository
import com.puput.mymoviesubdua.data.api.InstanceAPI
import com.puput.mymoviesubdua.data.remote.RemoteDataSource
import com.puput.mymoviesubdua.ui.detail.DetailMovieActivityViewModel
import com.puput.mymoviesubdua.ui.movie.MovieViewModel
import com.puput.mymoviesubdua.ui.tvshow.TvShowViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyCatalogueMovie : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyCatalogueMovie)
            modules(AppModule)
        }
    }
}

val AppModule = module {
    single {
        InstanceAPI.retrofit
    }
    single {
        RemoteDataSource(get())
    }

    single {
        MovieRepository(get())
    }
    viewModel {
        MovieViewModel(get())

    }
    viewModel {
        TvShowViewModel(get())

    }
    viewModel {
        DetailMovieActivityViewModel(get())
    }

}

