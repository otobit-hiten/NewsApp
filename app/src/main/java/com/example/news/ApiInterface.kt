package com.example.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "544796e4b80b49448304273f40a270cb"
interface ApiInterface {


    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getNews(@Query("country")country: String, @Query("page") page: Int) : Call<NewsResponse>

    //https://newsapi.org/v2/top-headlines?apiKey=544796e4b80b49448304273f40a270cb&country=in&page=1
}