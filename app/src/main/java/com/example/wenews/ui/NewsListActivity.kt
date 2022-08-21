package com.example.wenews.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wenews.R

import com.example.wenews.model.DummyData
import com.example.wenews.model.NewsModel
import com.example.wenews.model.football_model.PostModel
import com.example.wenews.ui.adapter.NewsListAdapter
import com.example.wenews.ui.fragment.NewsDetailFragment
import com.example.wenews.ui.listener.NewsListListener
import kotlinx.android.synthetic.main.activity_news_list.*
class NewsListActivity :AppCompatActivity(),NewsListListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setRecyclerViewData()
    }

    private fun setRecyclerViewData(){

        rv_news_list.layoutManager =LinearLayoutManager(this@NewsListActivity,RecyclerView.VERTICAL,false)
       // rv_news_list.adapter=NewsListAdapter(listItems = DummyData().newsListSample, Listener = this@NewsListActivity)
    }

    override fun onNewsItemClicked(news_item: PostModel) {
       supportFragmentManager.beginTransaction().replace(R.id.fragment_container,NewsDetailFragment.getNewsDetailFragment(item = news_item)).addToBackStack(null).commit()
    }
}