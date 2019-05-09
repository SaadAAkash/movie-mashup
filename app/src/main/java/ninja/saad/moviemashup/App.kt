package ninja.saad.moviemashup

import android.app.Application
import ninja.saad.moviemashup.di.AppComponent
import ninja.saad.moviemashup.di.BaseModule
import ninja.saad.moviemashup.di.DaggerAppComponent
import ninja.saad.moviemashup.di.NetworkModule
import com.facebook.drawee.backends.pipeline.Fresco
import ninja.saad.moviemashup.util.Constant

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        initAppComponent()
    }

    private fun initAppComponent() {
        this.appComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule(Constant.BASE_URL))
            .build()
    }


}