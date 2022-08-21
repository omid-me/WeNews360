package com.example.wenews.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import com.example.wenews.R

import com.example.wenews.model.NewsModel
import com.example.wenews.model.football_model.PostModel
import kotlinx.android.synthetic.main.fragment_news_detail.*
import kotlinx.android.synthetic.main.item_news_list.*

class NewsDetailFragment:Fragment(R.layout.fragment_news_detail),View.OnClickListener {
   // var newsDetailItem :NewsModel?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      news_detail_cover.load(newsDetailItem?.cover)
        tv_news_detail_title.text=newsDetailItem?.title
        tv_news_detail_description.text=newsDetailItem?.body
       iv_news_detail_back.setOnClickListener(this)


    }

    companion object{
        var newsDetailItem : PostModel? = null
        fun getNewsDetailFragment(item:PostModel):NewsDetailFragment{
            newsDetailItem=item
            return NewsDetailFragment()
        }
    }

    override fun onClick(view: View?) {
       when(view){

           iv_news_detail_back->activity?.onBackPressed()
       }
    }

}