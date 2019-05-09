package ninja.saad.moviemashup.di

import android.content.Context
import ninja.saad.moviemashup.util.NavigationManager
import ninja.saad.moviemashup.util.Navigator
import dagger.Module
import dagger.Provides
import ninja.saad.moviemashup.features.dashboard.PageViewModel
import ninja.saad.moviemashup.features.dashboard.PageViewModel_Factory

@Module
class ContextModule(val context: Context) {

    @ContextScope
    @Provides
    fun providesNavigator(): Navigator {
        return NavigationManager(context)
    }

}