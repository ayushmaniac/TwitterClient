package com.client.twitter.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.client.twitter.ui.base.BaseActivity
import com.client.twitter.ui.main.MainViewModel
import com.client.twitter.utils.ViewModelProviderFactory
import com.client.twitter.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

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
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(networkHelper)
        }).get(MainViewModel::class.java)

}