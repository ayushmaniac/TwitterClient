package com.client.twitter.ui.main.viewmodel

import androidx.lifecycle.liveData
import com.client.twitter.data.repo.TweetsRepository
import com.client.twitter.ui.base.BaseViewModel
import com.client.twitter.utils.common.Resource
import com.client.twitter.utils.network.NetworkHelper
import kotlinx.coroutines.Dispatchers

/**
 * Created by ayushshrivastava on 01/11/20.
 */
class MainViewModel(networkHelper: NetworkHelper, private val tweetsRepository: TweetsRepository)
    : BaseViewModel(networkHelper){

    override fun onCreate() {
    }

    fun getTweets() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = tweetsRepository.fetchTweets()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}