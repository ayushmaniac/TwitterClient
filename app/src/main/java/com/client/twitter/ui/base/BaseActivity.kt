package com.client.twitter.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.client.twitter.TwitterClientApplication
import com.client.twitter.di.component.ActivityComponent
import com.client.twitter.di.component.DaggerActivityComponent
import com.client.twitter.di.module.ActivityModule
import javax.inject.Inject

/**
 * Created by ayushshrivastava on 01/11/20.
 */
abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

      private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as TwitterClientApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()


    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    @LayoutRes
    protected abstract fun provideLayoutId(): Int
    protected abstract fun setupView(savedInstanceState: Bundle?)

}