package com.client.twitter.di.module

import android.content.Context
import androidx.room.Room
import com.client.twitter.TwitterClientApplication
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

 /*   @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()




    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService = NetworkEssentials.create(
        BuildConfig.BASE_URL,
        application.cacheDir,
        10 * 1024 * 1024 // 10MB

    )

    @Provides
    @Singleton
    fun getNewsDatabase() = Room.databaseBuilder(
        application,
        NewsDatabase::class.java,
        "news_database")
        .build()
*/
}
