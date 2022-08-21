package com.example.wenews.ui.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wenews.R
import com.example.wenews.dto.football_360_model.getFootballPostModel

import com.example.wenews.model.DummyData
import com.example.wenews.model.NewsModel
import com.example.wenews.model.football_model.PostModel
import com.example.wenews.network.RetrofitObject
import com.example.wenews.ui.adapter.NewsListAdapter
import com.example.wenews.ui.fragment.NewsDetailFragment
import com.example.wenews.ui.listener.NewsListListener
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOError
import java.io.IOException


class HomeFragment : Fragment(R.layout.fragment_home), NewsListListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setRecyclerViewData()
        lifecycleScope.launchWhenCreated {
            progressbar.visibility=View.VISIBLE
            val response=try {
             //   RetrofitObject.newsApiObject.getNewsPosts()
                RetrofitObject.newsApiObject.getFootballNewsPosts(page = "news-new")

            }catch (ioError:IOException){
                progressbar.visibility=View.GONE
                Log.d("MC_",ioError.toString())
                return@launchWhenCreated

            }catch (httpError:HttpException){
                progressbar.visibility=View.GONE
                Log.d("MC_",httpError.toString())
                return@launchWhenCreated
            }

            progressbar.visibility=View.GONE
            Log.d("MC_",response.body().toString())
            if (response.isSuccessful&&response.body()!=null)
            setRecyclerViewData(response.body()!![0].getFootballPostModel())else
                Log.d("MC_","response is null or error")
        }

    }

    private fun setRecyclerViewData(item:List<PostModel>) {

        rv_news_list.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rv_news_list.adapter =
            NewsListAdapter(listItems = item, Listener = this@HomeFragment)
    }

    override fun onNewsItemClicked(news_item: PostModel) {
        requireActivity().supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            NewsDetailFragment.getNewsDetailFragment(item = news_item)
        ).addToBackStack(null).commit()
    }
}