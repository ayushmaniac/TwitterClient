package com.client.twitter.data.repo

import androidx.lifecycle.LiveData
import com.client.twitter.data.local.TweetsDatabase
import com.client.twitter.data.model.Datum
import com.client.twitter.data.model.Tweets
import com.client.twitter.data.remote.NetworkService
import com.client.twitter.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ayushshrivastava on 01/11/20.
 */

@Singleton
class TweetsRepository @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val networkService: NetworkService,
    private val tweetsDatabase: TweetsDatabase
){

   suspend fun fetchTweets(): LiveData<List<Datum>> {
        if(networkHelper.isNetworkConnected()){
         val fetchTweetsFromRemote =  networkService.getTweets()
           saveFetchedTweets(fetchTweetsFromRemote)
       }
       return tweetsDatabase.tweetsDao().getTweets()

   }

    private fun saveFetchedTweets(fetchTweetsFromRemote: Tweets) {
        fetchTweetsFromRemote.let {
            it.success?.let { success ->
                if(success){
                    tweetsDatabase.tweetsDao().saveTweets(it.data)
                }
            }

        }
    }
}