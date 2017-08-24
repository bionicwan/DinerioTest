package com.dinerio.dineriotest.modules.login.data

import com.dinerio.dineriotest.modules.login.ApiClient
import com.dinerio.dineriotest.networking.ApiManager
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by JC on 23/08/2017.
 */
class LoginApiClient: ApiClient {
    override fun login(username: String, password: String,
                       success: (String) -> Unit, error: (Throwable) -> Unit) {

        val params = JsonObject()
        params.addProperty("username", username)
        params.addProperty("password", password)

        val apiService = ApiManager.create()
        val apiCall = apiService.login(params)

        apiCall.enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                if(response != null && response.isSuccessful) {
                    if(response.body() != null) {
                        val tokenElement = response.body()?.get("access_token")
                        success.invoke(tokenElement?.asString ?: "")
                    }
                }
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
            }
        })
    }
}
