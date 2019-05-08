package ninja.saad.moviemashup.di

import dagger.Subcomponent
import ninja.saad.moviemashup.features.dashboard.MainActivity


@ContextScope
@Subcomponent(modules = arrayOf(ContextModule::class))
interface ContextComponent {

    fun inject(mainActivity: MainActivity)

}