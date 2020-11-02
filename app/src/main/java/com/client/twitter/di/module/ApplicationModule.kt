package com.client.twitter.di.module

import android.content.Context
import androidx.room.Room
import com.client.twitter.BuildConfig
import com.client.twitter.TwitterClientApplication
import com.client.twitter.data.local.TweetsDatabase
import com.client.twitter.data.remote.NetworkEssentials
import com.client.twitter.data.remote.NetworkService
import com.client.twitter.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Module
class ApplicationModule(private val application : TwitterClientApplication) {
    @Provides
    fun provideContext() : Context = application

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService = NetworkEssentials.create(
        BuildConfig.BASE_URL,
        application.cacheDir,
        10 * 1024 * 1024 // 10MB

    )

    @Provides
    @Singleton
    fun getTweetsDatabase() = Room.databaseBuilder(
        application,
        TweetsDatabase::class.java,
        "tweets_database")
        .build()
}
