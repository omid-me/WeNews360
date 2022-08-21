package com.example.wenews.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wenews.ui.fragment.news_fragment.EuropeNewsFragment
import com.example.wenews.ui.fragment.news_fragment.IranNewsFragment
import com.example.wenews.ui.fragment.news_fragment.KharejiNewsFragment

class NewsViewPagerAdapter(fm:Fragment) :FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
      return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){

            0->{
                IranNewsFragment()
            }
            1->{
                KharejiNewsFragment()
            }
            2->{
                EuropeNewsFragment()
            }
            else ->{
                IranNewsFragment()

            }        }
    }}