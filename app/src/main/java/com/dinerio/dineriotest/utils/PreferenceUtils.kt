package com.dinerio.dineriotest.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by JC on 23/08/2017.
 */
class PreferenceUtils internal constructor(context: Context) {
    val PREFERENCES_NAME = "PropiedadesSharedPreferences"
    var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        var sharedPreferencesHelper: PreferenceUtils? = null

        @JvmStatic
        fun getInstance(context: Context): PreferenceUtils {
            if (sharedPreferencesHelper == null) {
                sharedPreferencesHelper = PreferenceUtils(context)
            }
            return sharedPreferencesHelper!!
        }
    }

    private fun getStringValueFromSharedPreferences(key: String) =
            sharedPreferences?.getString(key, "")

    private fun saveStringValueToSharedPreferences(key: String, value: String) {
        val editor = sharedPreferences?.edit()
        editor?.putString(key, value)
        editor?.commit()
    }

    /**
     * Store user token
     */
    val USER_TOKEN_PREFERENCE = "user_token_preference"

    fun saveUserToken(token: String) {
        this.saveStringValueToSharedPreferences(USER_TOKEN_PREFERENCE,
                token)
    }

    fun getUserToken() = this.getStringValueFromSharedPreferences(USER_TOKEN_PREFERENCE)
}