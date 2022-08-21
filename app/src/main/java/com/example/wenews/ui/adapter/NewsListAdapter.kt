package com.example.wenews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.wenews.R

import com.example.wenews.model.NewsModel
import com.example.wenews.model.football_model.PostModel
import com.example.wenews.ui.listener.NewsListListener
import kotlinx.android.synthetic.main.item_news_list.view.*

class NewsListAdapter(val listItems : List<PostModel>,val Listener:NewsListListener) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_list, parent, false)
        return NewsListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsListViewHolder).bindData(listItems[position],Listener)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class NewsListViewHolder( val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: PostModel,Listener: NewsListListener) {
        itemView.tv_news_list_title.text =item.title
            itemView.tv_news_list_description.text=item.body
            itemView.iv_news_list_cover.load(item.cover)
            itemView.tv_news_list_author.text=item.author
            itemView.setOnClickListener {
                Listener.onNewsItemClicked(news_item = item)
            }
        }
    }
}