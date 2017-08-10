package com.bill.kotlinexercise.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.bill.kotlinexercise.R
import com.bill.kotlinexercise.delegate.DelegateExt
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    var userName: String by DelegateExt.preference(this, "userName", "")
    var passWord: Int by DelegateExt.preference(this, "passWord", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        aet_user_name.setText(userName)
        aet_pwd.setText(passWord.toString())

        abtn_login.setOnClickListener {
            val user: String = aet_user_name.text.toString()
            val pwd: String = aet_pwd.text.toString()
            if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pwd)) {
                userName = user
                passWord = pwd.toInt()
                startActivity<ForecastActivity>()
            }
        }
    }
}
