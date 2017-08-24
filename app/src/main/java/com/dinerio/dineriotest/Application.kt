package com.dinerio.dineriotest

import android.app.Application
import com.dinerio.dineriotest.utils.PreferenceUtils
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by JC on 23/08/2017.
 */
class Application: Application() {
    private var mPreferenceUtils: PreferenceUtils? = null

    companion object {
        lateinit var instance: com.dinerio.dineriotest.Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)
    }

    fun getPreferenceUtils(): PreferenceUtils? {
        if(mPreferenceUtils == null)
            mPreferenceUtils = PreferenceUtils.getInstance(this)

        return mPreferenceUtils
    }
}