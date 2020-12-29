package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.fragment.Week1Fragment
import com.example.myapplication.week2.fragment.Week2Fragment

class MyAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }


    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> Week1Fragment()
            else ->
                Week2Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val pageTitles = arrayOf("WEEK 1","WEEK 2")
        return pageTitles[position]
    }
}