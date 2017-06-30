package com.bill.kotlinexercise.domain

/**
 * Created by Bill on 2017/6/30.
 */
interface Command<T> {
    fun execute(): T
}

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast {
        return dailyForecast[position]
    }

    fun length(): Int {
        return dailyForecast.size
    }
}

data class Forecast(val data: String, val description: String, val high: Int, val low: Int, val iconUrl: String)