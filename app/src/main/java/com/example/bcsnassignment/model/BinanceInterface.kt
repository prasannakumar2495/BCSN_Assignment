package com.example.bcsnassignment.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BinanceInterface {
    @GET("24hr")
    fun getData(): Call<List<BinanceAPIItem>>
    //(@Query("page") page: Int)
}