package com.dinerio.dineriotest.modules.login

/**
 * Created by JC on 23/08/2017.
 */
interface View {
    fun displayUsernameError(message: String)
    fun displayPasswordError(message: String)
    fun displayLoginError(message: String)
    fun launchHome()
}

interface Presenter {
    fun sendData(username: String?, password: String?)
}

interface ApiClient {
    fun login(username: String, password: String, success: (String) -> Unit,
              error: (Throwable) -> Unit)
}