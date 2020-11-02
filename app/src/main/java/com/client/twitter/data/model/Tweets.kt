package com.client.twitter.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ayushshrivastava on 01/11/20.
 */


data class Tweets (

    @SerializedName("success")
    @Expose
    var success: Boolean? = null,

    @SerializedName("data")
    @Expose
    var data: MutableList<Datum> = ArrayList()



)