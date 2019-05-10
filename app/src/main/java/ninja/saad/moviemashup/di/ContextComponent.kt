package ninja.saad.moviemashup.di

import dagger.Subcomponent
import ninja.saad.moviemashup.features.discover.DiscoverMoviesActivity
import ninja.saad.moviemashup.features.popularandtoprated.SortedMovieListActivity
import ninja.saad.moviemashup.features.trending.TrendingMoviesActivity


@ContextScope
@Subcomponent(modules = arrayOf(ContextModule::class))
interface ContextComponent {

    fun inject(mainActivity: DiscoverMoviesActivity)
    fun injectTrendingActivity(trendingMoviesActivity: TrendingMoviesActivity)
    fun injectPopularActivity(popularActivity: SortedMovieListActivity)

}