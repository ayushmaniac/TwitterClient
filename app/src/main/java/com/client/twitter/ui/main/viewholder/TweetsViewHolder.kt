package com.client.twitter.ui.main.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.client.twitter.R
import com.client.twitter.data.model.Datum
import com.client.twitter.utils.display.RealPathUtil
import kotlinx.android.synthetic.main.tweets_row.view.*



/**
 * Created by ayushshrivastava on 01/11/20.
 */
class TweetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

     fun bindTweets(tweet: Datum) {
         loadProfileImage(tweet.profileImageUrl)
        itemView.tvName.text = tweet.name
        itemView.tvDescription.text = tweet.text
        itemView.tvHandle.text = tweet.handle
        itemView.tvLikes.text = tweet.favoriteCount.toString()
        itemView.tvRetweets.text = tweet.retweetCount.toString()

     }

    private fun loadProfileImage(profileImageUrl: String?) {
        Glide.with(itemView.context)
            .load(profileImageUrl)
            .placeholder(R.drawable.ic_placeholder)
            .into(itemView.imageView)
    }

}