package com.anythingintellect.themoviedb.di

import android.content.Context
import com.anythingintellect.themoviedb.util.NavigationManager
import com.anythingintellect.themoviedb.util.Navigator
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val context: Context) {

    @ContextScope
    @Provides
    fun providesNavigator(): Navigator {
        return NavigationManager(context)
    }

}