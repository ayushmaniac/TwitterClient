package com.client.twitter

import android.app.Application
import com.client.twitter.di.component.ApplicationComponent
import com.client.twitter.di.component.DaggerApplicationComponent
import com.client.twitter.di.module.ApplicationModule

/**
 * Created by ayushshrivastava on 01/11/20.
 */
class TwitterClientApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}