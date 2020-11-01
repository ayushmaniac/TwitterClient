package com.client.twitter.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.client.twitter.R
import com.client.twitter.di.component.ActivityComponent
import com.client.twitter.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
    }
}