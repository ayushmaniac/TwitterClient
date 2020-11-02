package com.client.twitter.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.client.twitter.BuildConfig
import com.client.twitter.data.model.Datum

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Database(entities = [Datum::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
abstract class TweetsDatabase : RoomDatabase(){

    abstract fun tweetsDao(): TweetsDao

    lateinit var instance: TweetsDatabase
}