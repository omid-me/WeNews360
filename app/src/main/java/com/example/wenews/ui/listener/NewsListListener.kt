package com.example.wenews.ui.listener


import com.example.wenews.model.NewsModel
import com.example.wenews.model.football_model.PostModel

interface NewsListListener {
    fun onNewsItemClicked(news_item:PostModel)
}