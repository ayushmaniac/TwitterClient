package com.client.twitter.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.client.twitter.R
import com.client.twitter.di.component.ActivityComponent
import com.client.twitter.ui.base.BaseActivity

class SplashActivity : BaseActivity<SplashViewModel>() {

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun setupView(savedInstanceState: Bundle?) {
    }
}