package com.example.rdiandroiddevelopertest.api

import com.example.diggieservice.enum.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DigieServiceClient {
    private val retrofitClient: Retrofit.Builder by lazy {

        Retrofit.Builder()
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
    }
    val DIGIE_SERVICE_INTERFACE:DigieServiceInterface by lazy {
        retrofitClient.build().create(DigieServiceInterface::class.java)
    }
}