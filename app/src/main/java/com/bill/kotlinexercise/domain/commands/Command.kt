package com.bill.kotlinexercise.domain.commands

/**
 * Created by Bill on 2017/6/30.
 */
interface Command<out T> {
    fun execute(): T
}
