package com.bill.kotlinexercise.data.server

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Bill on 2017/6/30.
 */
class ForecastRequest(val zipCode: String) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        Log.d(javaClass.simpleName, COMPLETE_URL + zipCode)
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}