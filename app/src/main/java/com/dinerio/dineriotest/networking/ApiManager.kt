package com.dinerio.dineriotest.networking

import com.dinerio.dineriotest.Application
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by JC on 23/08/2017.
 */
interface ApiManager {
    companion object Factory {
        fun create(): ApiManager {
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val builder = request.newBuilder()
                        val sessionStr = Application.instance.
                                getPreferenceUtils()?.getUserToken()
                        builder.header("authorization", "Bearer " + sessionStr)
                        builder.method(request.method(), request.body())
                        chain.proceed(builder.build())
                    }.build()

            val retrofit = Retrofit.Builder()
                    .baseUrl("https://dinerio.mx:8443/dinerio/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

            return retrofit.create(ApiManager::class.java)
        }
    }

    @POST("login")
    fun login(@Body params: JsonObject): Call<JsonObject>
}