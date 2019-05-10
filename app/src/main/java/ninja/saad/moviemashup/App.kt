package ninja.saad.moviemashup

import android.app.Application
import androidx.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco
import ninja.saad.moviemashup.di.AppComponent
import ninja.saad.moviemashup.di.BaseModule
import ninja.saad.moviemashup.di.DaggerAppComponent
import ninja.saad.moviemashup.di.NetworkModule
import ninja.saad.moviemashup.util.Constant

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        Fresco.initialize(this)
        initAppComponent()
    }

    private fun initAppComponent() {
        this.appComponent = DaggerAppComponent
            .builder()
            .baseModule(BaseModule(this))
            .networkModule(NetworkModule(Constant.BASE_URL))
            .build()
    }


}