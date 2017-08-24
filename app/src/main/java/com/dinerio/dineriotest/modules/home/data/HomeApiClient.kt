package com.dinerio.dineriotest.modules.home.data

import com.dinerio.dineriotest.Application
import com.dinerio.dineriotest.modules.home.ApiClient
import com.dinerio.dineriotest.networking.ApiManager
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by JC on 23/08/2017.
 */
class HomeApiClient: ApiClient {
    override fun getUserInfo(success: (String) -> Unit, error: (Throwable) -> Unit) {

        val apiService = ApiManager.create()
        val apiCall = apiService.me()
        apiCall.enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                if(response != null && response.isSuccessful) {
                    success.invoke("")
                } else {
                    error.invoke(Throwable("No fue posible acceder a los datos"))
                }
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
            }
        })
    }

}