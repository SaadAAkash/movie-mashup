package ninja.saad.moviemashup.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(BaseModule::class))
@Singleton
interface AppComponent {

    fun plusContext(contextModule: ContextModule): ContextComponent

}