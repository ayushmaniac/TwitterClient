package com.client.twitter.utils.display

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.client.twitter.R


/**
 * Created by ayushshrivastava on 02/11/20.
 */
class ItemDecorator: RecyclerView.ItemDecoration {
    private var mDivider: Drawable? = null

    constructor(context: Context) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.item_divider)
    }

    constructor(context: Context, drawable: Int) {
        mDivider = ContextCompat.getDrawable(context, drawable)
    }

    override fun onDrawOver(c: Canvas, recyclerView: RecyclerView, state: RecyclerView.State) {

        val left = recyclerView.paddingLeft
        val right = recyclerView.width - recyclerView.paddingRight

        val childCount = recyclerView.childCount
        for (i in 0 until childCount-1) {

            val child = recyclerView.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider!!.intrinsicHeight
            mDivider!!.setBounds(left, top, right, bottom)
            mDivider!!.draw(c)

        }


    }

}