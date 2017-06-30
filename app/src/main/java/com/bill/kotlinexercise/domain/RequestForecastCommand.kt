package com.bill.kotlinexercise.domain

import com.bill.kotlinexercise.data.ForecastDataMapper
import com.bill.kotlinexercise.network.ForecastRequest

/**
 * Created by Bill on 2017/6/30.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastResult = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastResult.execute())
    }

}