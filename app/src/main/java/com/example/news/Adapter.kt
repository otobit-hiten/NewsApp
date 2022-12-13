package com.example.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context, val article: List<Article>?):RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val inflater :LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.item_news,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article : Article = article!![position]
        holder.txtTitle.text = article.title
        holder.txtDes.text = article.content
        Glide.with(context).load(article.urlToImage).into(holder.images)
        holder.images.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return article!!.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var txtTitle = itemView.findViewById<TextView>(R.id.title)
        var txtDes = itemView.findViewById<TextView>(R.id.descripition)
        var images = itemView.findViewById<ImageView>(R.id.image)
    }
}

