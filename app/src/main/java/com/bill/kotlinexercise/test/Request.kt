package com.bill.kotlinexercise.test

import android.util.Log
import java.net.URL

/**
 * Created by Bill on 2017/6/30.
 */
class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.e(javaClass.simpleName, forecastJsonStr)
    }
}