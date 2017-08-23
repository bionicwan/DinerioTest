package com.dinerio.dineriotest.modules.login.presenter

import com.dinerio.dineriotest.Application
import com.dinerio.dineriotest.modules.login.ApiClient
import com.dinerio.dineriotest.modules.login.Presenter
import com.dinerio.dineriotest.modules.login.View
import com.dinerio.dineriotest.modules.login.data.LoginApiClient

/**
 * Created by JC on 23/08/2017.
 */
class LoginPresenter(view: View): Presenter {
    private var mView = view
    private var mApiClient: ApiClient? = null

    override fun sendData(username: String?, password: String?) {
        if(isUsernameValid(username) && isPasswordValid(password)) {
            getApiClient()?.login(username!!, password!!,
                    {
                        Application.instance.getPreferenceUtils()?.saveUserToken(it)
                    },
                    {})
        }
    }

    private fun isUsernameValid(username: String?): Boolean {
        var isValid = true
        if(username == null || username.isEmpty() || username.isBlank()) {
            isValid = false
            mView.displayUsernameError("Ingresa tu usuario.")
        }

        return isValid
    }

    private fun isPasswordValid(password: String?): Boolean {
        var isValid = true
        if(password == null || password.isEmpty() || password.isBlank()) {
            isValid = false
            mView.displayPasswordError("Ingresa tu password.")
        }

        return isValid
    }

    private fun getApiClient(): ApiClient? {
        if(mApiClient == null)
            mApiClient = LoginApiClient()

        return mApiClient
    }
}