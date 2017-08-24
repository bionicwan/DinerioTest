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
            mView.launchLogin()
        }, 500)
    }

}