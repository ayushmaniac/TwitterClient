package com.client.twitter.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.client.twitter.data.repo.TweetsRepository
import com.client.twitter.ui.base.BaseActivity
import com.client.twitter.ui.main.viewmodel.MainViewModel
import com.client.twitter.ui.splash.SplashViewModel
import com.client.twitter.utils.ViewModelProviderFactory
import com.client.twitter.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Module
class ActivityModule (private val activity: BaseActivity<*>){

    @Provides
    fun provideContext(
    ) : Context = activity

    @Provides
    fun provideMainViewModel(
        networkHelper: NetworkHelper,
        tweetsRepository: TweetsRepository
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(networkHelper,tweetsRepository)
        }).get(MainViewModel::class.java)

    @Provides
    fun provideSplashViewModel(
        networkHelper: NetworkHelper
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(networkHelper)
        }).get(SplashViewModel::class.java)

}