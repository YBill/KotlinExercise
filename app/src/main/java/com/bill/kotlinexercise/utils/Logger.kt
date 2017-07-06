package com.bill.kotlinexercise.utils

import android.util.Log

/**
 * Created by Bill on 2017/7/6.
 */
class Logger {

    companion object {
        val instance = Logger()
    }

    fun i(msg: String, tag: String = "Bill") {
        Log.i(tag, msg)
    }

}