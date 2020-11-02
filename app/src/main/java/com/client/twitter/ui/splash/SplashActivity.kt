package com.client.twitter.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.client.twitter.R
import com.client.twitter.di.component.ActivityComponent
import com.client.twitter.ui.base.BaseActivity
import com.client.twitter.ui.main.ui.MainActivity

class SplashActivity : BaseActivity<SplashViewModel>() {

    private val SPLASH_SCREEN_TIME_OUT : Long= 3000

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(
        this
    )

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun setupView(savedInstanceState: Bundle?) {
        startSplash()
    }

    private fun startSplash() {
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, MainActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_SCREEN_TIME_OUT)
    }
}