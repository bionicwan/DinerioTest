package com.dinerio.dineriotest.modules.login.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.dinerio.dineriotest.R
import com.dinerio.dineriotest.modules.home.view.HomeActivity
import com.dinerio.dineriotest.modules.login.Presenter
import com.dinerio.dineriotest.modules.login.View
import com.dinerio.dineriotest.modules.login.presenter.LoginPresenter

/**
 * Created by JC on 23/08/2017.
 */
class LoginActivity : AppCompatActivity(), View {
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

    private var mPresenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)

        mPresenter = LoginPresenter(this)
    }

    /**
     * View methods
     */
    override fun displayUsernameError(message: String) {
    }

    override fun displayPasswordError(message: String) {
    }

    override fun displayLoginError(message: String) {
    }

    override fun launchHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    /**
     * OnClick
     */
    @OnClick(R.id.btn_send_data)
    fun onSendDataClicked() {
        mPresenter?.sendData(fieldUsername?.text.toString(),
                fieldPassword?.text.toString())
    }
}