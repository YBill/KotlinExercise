package com.bill.kotlinexercise.delegate

import kotlin.properties.ReadWriteProperty

/**
 * Created by Bill on 2017/7/3.
 */
object DelegateExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}