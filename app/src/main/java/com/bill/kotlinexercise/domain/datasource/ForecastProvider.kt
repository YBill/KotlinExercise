package com.bill.kotlinexercise.domain.datasource

import com.bill.kotlinexercise.db.ForecastDb
import com.bill.kotlinexercise.domain.model.Forecast
import com.bill.kotlinexercise.domain.model.ForecastList

/**
 * Created by Bill on 2017/7/6.
 */
class ForecastProvider {

    companion object {
        val forecastDb = ForecastDb()
    }

    fun requestByZipCode(zipCode: String): ForecastList? {
        val list = forecastDb.requestForecastByZipCode(zipCode, 0)
        return list
    }

    fun requestForecast(id: Long): Forecast? {
        val forecast = forecastDb.requestDayForecast(id)
        return forecast
    }

    fun saveForecastList(list: ForecastList) {
        forecastDb.saveForecast(list)
    }

}