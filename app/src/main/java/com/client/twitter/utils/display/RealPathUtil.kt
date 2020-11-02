package com.client.twitter.utils.display

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.net.URL


/**
 * Created by ayushshrivastava on 02/11/20.
 */
object RealPathUtil {

     fun getAbsoluteUrl(url: String?) : Bitmap {
        var bitmap : Bitmap? = null
                val document = Jsoup.connect(url).get()
        return bitmap!!
    }

}