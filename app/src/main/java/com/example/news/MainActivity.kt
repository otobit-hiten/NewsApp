package com.example.news

import android.R.attr.orientation
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Listener {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    lateinit var adapter: Adapter

    private var article  = mutableListOf<Article>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(NewsViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.listener = this
        viewModel.news()

    }

    override fun onStarted() {
    }

    override fun onSuccess(mutableLiveData: MutableLiveData<Resource<NewsResponse>>) {
        mutableLiveData.observe(this, Observer {
            when(it.status){
                Status.SUCCESS ->{
                    val data = it.data
                    if(data != null){
                        adapter = Adapter( this, data.articles)
                        binding.recycle.adapter = adapter
                        binding.recycle.layoutManager = LinearLayoutManager(this)
                        Log.d("EEEEEEEE","${data.articles}")
                    }
                }
                Status.ERROR ->{
                    Toast.makeText(applicationContext, "Error:$it", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING ->{
                }
            }
        })
    }

    override fun onFailure(message: String) {
        Toast.makeText(applicationContext, "Failed:$message", Toast.LENGTH_SHORT).show()
    }
}