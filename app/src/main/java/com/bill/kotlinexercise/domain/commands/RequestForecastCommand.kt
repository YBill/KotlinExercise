package com.bill.kotlinexercise.domain.commands

import com.bill.kotlinexercise.data.server.ForecastDataMapper
import com.bill.kotlinexercise.domain.model.ForecastList
import com.bill.kotlinexercise.data.server.ForecastRequest

/**
 * Created by Bill on 2017/6/30.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastResult = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastResult.execute())
    }

}