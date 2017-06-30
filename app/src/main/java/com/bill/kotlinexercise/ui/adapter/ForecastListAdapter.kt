package com.bill.kotlinexercise.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.bill.kotlinexercise.domain.ForecastList

/**
 * Created by Bill on 2017/6/15.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return weekForecast.length()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$data - $description - $high/$low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}