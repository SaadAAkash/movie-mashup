package ninja.saad.moviemashup.di

import dagger.Module
import dagger.Provides
import ninja.saad.moviemashup.network.MovieAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(val baseUrl: String) {

    @Provides
    @Singleton
    fun providesMovieAPI(retrofit: Retrofit): MovieAPI {
        return retrofit.create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit(adapterFactory: RxJava2CallAdapterFactory, converterFactory: JacksonConverterFactory): Retrofit {
        val builder: Retrofit.Builder = Retrofit.Builder();
        builder.baseUrl(baseUrl)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(converterFactory)
        return builder.build();
    }

    @Provides
    @Singleton
    fun providesRxJavaCallAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun providesJacksonConverterFactory(): JacksonConverterFactory {
        return JacksonConverterFactory.create()
    }
}