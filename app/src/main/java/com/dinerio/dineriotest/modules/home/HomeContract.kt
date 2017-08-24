package com.dinerio.dineriotest.modules.home

/**
 * Created by JC on 23/08/2017.
 */
interface View {
    fun displayEmail(email: String)
}

interface Presenter {
    fun initialize()
}

interface ApiClient {
    fun getUserInfo(success: (String) -> Unit, error: (Throwable) -> Unit)
}