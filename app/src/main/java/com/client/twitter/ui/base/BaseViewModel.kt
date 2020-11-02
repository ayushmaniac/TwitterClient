package com.client.twitter.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.client.twitter.R
import com.client.twitter.utils.common.Resource
import com.client.twitter.utils.network.NetworkHelper
import javax.net.ssl.HttpsURLConnection

/**
 * Created by ayushshrivastava on 01/11/20.
 */
abstract class BaseViewModel(
    private val networkHelper: NetworkHelper
) : ViewModel() {

    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()
    abstract fun onCreate()
}