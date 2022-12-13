package com.example.news

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository {

    fun getNews(country:String, page:Int) : MutableLiveData<Resource<NewsResponse>>{
        val mutableLiveData : MutableLiveData<Resource<NewsResponse>> = MutableLiveData()

        mutableLiveData.postValue(Resource.loading("Please Wait",null))

        val call : Call<NewsResponse>? = ApiClient.service?.getNews(country,page)
        call?.enqueue(object : Callback<NewsResponse?> {
            override fun onResponse(call: Call<NewsResponse?>, response: Response<NewsResponse?>) {
                    val newsResponse: NewsResponse? = response.body()
                if(newsResponse != null){
                    Log.d("NewsHiten","$newsResponse")
                    mutableLiveData.postValue(Resource.success(newsResponse))
                }
            }

            override fun onFailure(call: Call<NewsResponse?>, t: Throwable) {
                mutableLiveData.postValue( Resource.error("Something Went Wrong", null))
            }
        })

        return mutableLiveData
    }
}