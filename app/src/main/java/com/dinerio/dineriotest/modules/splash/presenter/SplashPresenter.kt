package com.dinerio.dineriotest.modules.splash.presenter

import android.os.Handler
import com.dinerio.dineriotest.Application
import com.dinerio.dineriotest.modules.splash.Presenter
import com.dinerio.dineriotest.modules.splash.View

/**
 * Created by JC on 23/08/2017.
 */
class SplashPresenter(view :View): Presenter {

    private val mView = view

    override fun initialize() {
        val handler = Handler()
        handler.postDelayed({
            val userToken = Application.instance.getPreferenceUtils()?.getUserToken()
            if(userToken != null && userToken.isNotEmpty()) {
                mView.launchHome()
            } else {
                mView.launchLogin()
            }
        }, 500)
    }

}