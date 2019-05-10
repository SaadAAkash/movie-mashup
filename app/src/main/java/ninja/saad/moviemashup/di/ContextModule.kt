package ninja.saad.moviemashup.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ninja.saad.moviemashup.util.NavigationManager
import ninja.saad.moviemashup.util.Navigator

@Module
class ContextModule(val context: Context) {

    @ContextScope
    @Provides
    fun providesNavigator(): Navigator {
        return NavigationManager(context)
    }

}