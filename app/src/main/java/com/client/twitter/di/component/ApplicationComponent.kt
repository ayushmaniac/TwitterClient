package com.client.twitter.di.component

import android.content.Context
import com.client.twitter.TwitterClientApplication
import com.client.twitter.data.repo.TweetsRepository
import com.client.twitter.di.module.ApplicationModule
import com.client.twitter.utils.network.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: TwitterClientApplication)

    fun getContext() : Context

    fun getNetworkHelper(): NetworkHelper

    fun getTweetsRepository() : TweetsRepository



}