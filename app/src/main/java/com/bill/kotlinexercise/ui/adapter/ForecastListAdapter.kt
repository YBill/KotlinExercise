package com.bill.kotlinexercise.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bill.kotlinexercise.R
import com.bill.kotlinexercise.domain.model.Forecast
import com.bill.kotlinexercise.domain.model.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_forecast.view.*

/**
 * Created by Bill on 2017/6/15.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: OnItemClickListener) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return weekForecast.length()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position], weekForecast.city)
    }

    class ViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
//        private val iconView: ImageView
//        private val dateView: TextView
//        private val descriptionView: TextView
//        private val maxTemperatureView: TextView
//        private val minTemperatureView: TextView

        /*init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(Rze.id.minTemperature)
        }*/

        fun bindForecast(forecast: Forecast, city: String) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = this.convertDate()
                itemView.description.text = description
                itemView.maxTemperature.text = high.toString()
                itemView.minTemperature.text = low.toString()
                itemView.setOnClickListener {
                    itemClick.invoke(forecast, city)
                }
            }
        }

    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast, city: String)
    }

}