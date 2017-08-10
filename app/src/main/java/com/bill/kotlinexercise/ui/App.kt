package com.bill.kotlinexercise.ui

import android.app.Application
import com.bill.kotlinexercise.delegate.DelegateExt

/**
 * Created by Bill on 2017/7/3.
 */
class App : Application() {

    companion object {
//        private var instance: Application? = null
//        fun instance() = instance!!
        var instance :App by DelegateExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DelegateExt.preference(instance, "", "")
    }

}