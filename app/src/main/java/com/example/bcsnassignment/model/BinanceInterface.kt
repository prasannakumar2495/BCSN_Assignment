package com.example.bcsnassignment.model

import retrofit2.Call
import retrofit2.http.GET

interface BinanceInterface {
    @GET("24hr")
    fun getData(): Call<List<BinanceAPIItem>>
}