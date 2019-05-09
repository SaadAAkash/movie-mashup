package ninja.saad.moviemashup.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import ninja.saad.moviemashup.util.ToastManager
import ninja.saad.moviemashup.util.Toaster
import dagger.Module
import dagger.Provides
import ninja.saad.moviemashup.data.MovieRepository
import ninja.saad.moviemashup.data.MovieRepositoryImpl
import ninja.saad.moviemashup.network.MovieAPI
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
abstract class BaseModule(val appContext: Context) {

    @Binds
    @Singleton
    abstract fun providesMovieRepository(api: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun providesViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory

}