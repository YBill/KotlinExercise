package com.bill.kotlinexercise.domain.datasource

import com.bill.kotlinexercise.domain.model.Forecast
import com.bill.kotlinexercise.domain.model.ForecastList

/**
 * Created by Bill on 2017/7/5.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: String, data: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}