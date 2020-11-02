package com.client.twitter.data.model

import androidx.room.*
import com.client.twitter.utils.common.Constants.TABLE_TWEETS
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ayushshrivastava on 01/11/20.
 */
@Entity(tableName = TABLE_TWEETS)
data class Datum (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0,

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    var name: String? = null,

    @SerializedName("handle")
    @Expose
     var handle: String? = null,

    @SerializedName("favoriteCount")
    @Expose
     var favoriteCount: Int? = null,

    @SerializedName("retweetCount")
    @Expose
     var retweetCount: Int? = null,

    @SerializedName("profileImageUrl")
    @Expose
     var profileImageUrl: String? = null,

    @SerializedName("text")
    @Expose
     var text: String? = null

)