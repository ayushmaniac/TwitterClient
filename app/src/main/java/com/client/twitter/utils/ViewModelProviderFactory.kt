package com.client.twitter.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Singleton
import kotlin.reflect.KClass

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Singleton
class ViewModelProviderFactory<T : ViewModel>(

    private val kClass: KClass<T>,
    private val creator: () -> T


) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(kClass.java)) return creator() as T

        throw IllegalArgumentException("Unknown class name")
    }
}