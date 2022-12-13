package com.example.news

import android.util.Log
import androidx.lifecycle.ViewModel

class NewsViewModel: ViewModel(){

    var country :String? = "in"
    var page:Int = 1
    var listener: Listener? = null


    fun news(){
        val mutableLiveData = Repository().getNews(country!!,page)
        listener?.onSuccess(mutableLiveData)
        Log.d("ffsgsdgf","$mutableLiveData")
    }
}