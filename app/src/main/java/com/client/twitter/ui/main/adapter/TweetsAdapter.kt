package com.client.twitter.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.client.twitter.R
import com.client.twitter.data.model.Datum
import com.client.twitter.ui.main.viewholder.TweetsViewHolder

/**
 * Created by ayushshrivastava on 01/11/20.
 */
class TweetsAdapter(private var listOfTweets : List<Datum>) : RecyclerView.Adapter<TweetsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsViewHolder =
        TweetsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tweets_row, parent, false))

    override fun onBindViewHolder(holder: TweetsViewHolder, position: Int) {
        val tweet = listOfTweets[position]
        holder.bindTweets(tweet)
    }

    override fun getItemCount(): Int = listOfTweets.size

    fun getFilteredList(filteredTweets: List<Datum>){
        this.listOfTweets = filteredTweets
       notifyDataSetChanged()
    }

}