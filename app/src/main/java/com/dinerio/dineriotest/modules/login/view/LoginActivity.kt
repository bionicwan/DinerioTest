package com.dinerio.dineriotest.modules.login.view

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.dinerio.dineriotest.R

/**
 * Created by JC on 23/08/2017.
 */
class LoginActivity : AppCompatActivity() {
    @JvmField @BindView(R.id.toolbar)
    var toolbar: Toolbar? = null
    @JvmField @BindView(R.id.wrapper_username)
    var wrapperUsername: TextInputLayout? = null
    @JvmField @BindView(R.id.wrapper_password)
    var wrapperPassword: TextInputLayout? = null
    @JvmField @BindView(R.id.field_username)
    var fieldUsername: TextInputEditText? = null
    @JvmField @BindView(R.id.field_password)
    var fieldPassword: TextInputEditText? = null
    @JvmField @BindView(R.id.btn_send_data)
    var btnSendData: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
    }
}