package com.anythingintellect.themoviedb.di

import dagger.Subcomponent
import ninja.saad.moviemashup.MainActivity


@ContextScope
@Subcomponent(modules = arrayOf(ContextModule::class))
interface ContextComponent {

    fun inject(mainActivity: MainActivity)

}