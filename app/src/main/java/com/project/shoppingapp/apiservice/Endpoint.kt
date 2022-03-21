package com.project.shoppingapp.apiservice


import com.project.shoppingapp.apiservice.pojos.readDashboard.Response
import retrofit2.Call

import retrofit2.http.GET


interface Endpoint {


    @GET("v2/5ec39cba300000720039c1f6")
    fun fetchDashboard(): Call<Response>

}