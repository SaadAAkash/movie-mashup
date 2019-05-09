package ninja.saad.moviemashup.di

import dagger.Subcomponent
import ninja.saad.moviemashup.features.discover.DiscoverMoviesActivity


@ContextScope
@Subcomponent(modules = arrayOf(ContextModule::class))
interface ContextComponent {

    fun inject(mainActivity: DiscoverMoviesActivity)

}