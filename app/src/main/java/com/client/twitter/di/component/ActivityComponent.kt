package com.client.twitter.di.component

import com.client.twitter.di.ActivityScope
import com.client.twitter.di.module.ActivityModule
import com.client.twitter.ui.main.MainActivity
import com.client.twitter.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by ayushshrivastava on 01/11/20.
 */

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(splashActivity: SplashActivity)
}