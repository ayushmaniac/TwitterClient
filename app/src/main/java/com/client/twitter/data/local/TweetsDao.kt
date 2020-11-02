package com.client.twitter.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.client.twitter.data.model.Datum

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Dao
interface TweetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTweets(listOfTweets : List<Datum>)

    @Query("select * from TWEETS")
    fun getTweets() : LiveData<List<Datum>>

}