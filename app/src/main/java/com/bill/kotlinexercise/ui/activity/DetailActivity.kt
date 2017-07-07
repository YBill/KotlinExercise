package com.bill.kotlinexercise.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.antonioleiva.weatherapp.extensions.color
import com.antonioleiva.weatherapp.extensions.textColor
import com.bill.kotlinexercise.R
import com.bill.kotlinexercise.domain.datasource.ForecastProvider
import com.bill.kotlinexercise.domain.model.Forecast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Bill on 2017/7/7.
 */
class DetailActivity : AppCompatActivity() {

    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        toolbar.title = intent.getStringExtra(CITY_NAME)

        getData(intent.getLongExtra(ID, -1))
    }

    private fun getData(id: Long) {
        val forecastDb = ForecastProvider()
        doAsync {
            val result = forecastDb.requestForecast(id)
            uiThread {
                if (result != null)
                    bindForecast(result)
            }
        }
    }

    private fun bindForecast(forecast: Forecast) = with(forecast) {
        Picasso.with(ctx).load(iconUrl).into(icon)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}º"
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })
    }


}