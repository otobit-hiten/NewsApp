package com.example.news

import androidx.lifecycle.MutableLiveData

interface Listener {
    fun onStarted()
    fun onSuccess(mutableLiveData: MutableLiveData<Resource<NewsResponse>>)
    fun onFailure(message:String)



}