package com.client.twitter.data.remote

import com.client.twitter.data.model.Tweets
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Singleton
interface NetworkService {

    @GET(Endpoints.TWEETS)
    suspend fun getTweets(): Tweets

}