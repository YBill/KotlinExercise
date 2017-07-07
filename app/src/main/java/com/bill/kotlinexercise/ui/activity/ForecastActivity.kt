package com.bill.kotlinexercise.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.bill.kotlinexercise.R
import com.bill.kotlinexercise.domain.commands.RequestForecastCommand
import com.bill.kotlinexercise.domain.datasource.ForecastProvider
import com.bill.kotlinexercise.domain.model.ForecastList
import com.bill.kotlinexercise.ui.adapter.ForecastListAdapter
import com.bill.kotlinexercise.utils.Logger
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.ctx
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
            val forecastDb = ForecastProvider()
            var list: ForecastList? = forecastDb.requestByZipCode("5375480")
            Logger.instance.i("list:" + list)
            if (list == null) {
                list = RequestForecastCommand("94043").execute()
                forecastDb.saveForecastList(list)
            }

            uiThread {
                forecastList.adapter = ForecastListAdapter(list!!) {
                    toast(it.data.toString())
                    val intent = Intent()
                    //获取intent对象
                    intent.setClass(ctx, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.ID, it.data)
                    intent.putExtra(DetailActivity.ID, it.description)
                    // 获取class是使用::反射
                    startActivity(intent)
                }
            }
        }
    }

}
