package com.dinerio.dineriotest.modules.home.presenter

import com.dinerio.dineriotest.modules.home.ApiClient
import com.dinerio.dineriotest.modules.home.Presenter
import com.dinerio.dineriotest.modules.home.View
import com.dinerio.dineriotest.modules.home.data.HomeApiClient

/**
 * Created by JC on 23/08/2017.
 */
class HomePresenter(view: View): Presenter {

    private val mView = view
    private var mApiClient: ApiClient? = null

    override fun initialize() {
        getApiClient()?.getUserInfo(
                {},
                {
                    mView.displayEmail(it.message!!)
                })
    }

    private fun getApiClient(): ApiClient? {
        if(mApiClient == null)
            mApiClient = HomeApiClient()

        return mApiClient
    }
}