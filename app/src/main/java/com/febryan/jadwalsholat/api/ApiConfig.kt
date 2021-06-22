package com.febryan.jadwalsholat.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    const val baseUrl = "https://api.banghasan.com/sholat/"

    fun getRetrofit() : Retrofit {
        //yang di bawah ini di ambil dari retrofit configurasi di dokumentasi retrofit
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

}