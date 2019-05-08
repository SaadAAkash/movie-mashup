package ninja.saad.moviemashup.di

import android.content.Context
import ninja.saad.moviemashup.util.ToastManager
import ninja.saad.moviemashup.util.Toaster
import dagger.Module
import dagger.Provides
import ninja.saad.moviemashup.data.MovieRepository
import ninja.saad.moviemashup.data.MovieRepositoryImpl
import ninja.saad.moviemashup.network.MovieAPI
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class BaseModule(val appContext: Context) {

    @Provides
    @Singleton
    fun providesMovieRepository(api: MovieAPI): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesToaster(): Toaster {
        return ToastManager(appContext)
    }

}