package com.bill.kotlinexercise.domain.model

/**
 * Created by Bill on 2017/7/5.
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast {
        return dailyForecast[position]
    }

    fun length(): Int {
        return dailyForecast.size
    }
}

data class Forecast(val id: Long, val data: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)