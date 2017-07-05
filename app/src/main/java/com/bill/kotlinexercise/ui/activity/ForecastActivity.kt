package com.bill.kotlinexercise.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.bill.kotlinexercise.R
import com.bill.kotlinexercise.db.ForecastDb
import com.bill.kotlinexercise.domain.commands.RequestForecastCommand
import com.bill.kotlinexercise.domain.model.ForecastList
import com.bill.kotlinexercise.ui.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
//        val forecastList: RecyclerView = find(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        doAsync {
            val forecastDb = ForecastDb()
            var list: ForecastList? = forecastDb.requestForecastByZipCode("5375480", 0)
            Log.e("Bill", "list:" + list)
            if (list != null) Log.e("Bill", "list::" + list[0].toString())
            if (list == null) {
                list = RequestForecastCommand("94043").execute()
                forecastDb.saveForecast(list)
            }


            uiThread {
                forecastList.adapter = ForecastListAdapter(list!!) { toast(it.data.toString()) }
            }
        }
    }

}
