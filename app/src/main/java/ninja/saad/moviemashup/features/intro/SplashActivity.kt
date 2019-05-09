package ninja.saad.moviemashup.features.intro

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_splash.*
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.core.BaseActivity
import ninja.saad.moviemashup.features.dashboard.MainActivity

class SplashActivity : BaseActivity() {

    private lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo = findViewById(R.id.logo)
        val custom_font = Typeface.createFromAsset(assets, "fonts/TitilliumWeb-SemiBold.ttf")
        textView.typeface = custom_font

        Handler().postDelayed({
            //first timer user logic goes here
            val i = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }, splashTimeOut.toLong())

        val myanim = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        logo.startAnimation(myanim)
    }

    companion object {
        private val splashTimeOut = 2000
    }
}