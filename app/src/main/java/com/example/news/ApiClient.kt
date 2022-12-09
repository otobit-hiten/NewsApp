package com.example.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    const val BASE_URL = "https://newsapi.org/"
    const val API_Key = "544796e4b80b49448304273f40a270cb"

    fun getInstance() :Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val service : ApiInterface? = getInstance().create(ApiInterface::class.java)
}