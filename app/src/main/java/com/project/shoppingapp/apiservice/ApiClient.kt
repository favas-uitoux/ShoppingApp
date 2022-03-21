package com.project.shoppingapp.apiservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




object ApiClient {

    var BASE_URL = "http://www.mocky.io/"
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> getClient(service: Class<T>): T{
        return retrofit.create(service)
    }



    }
