package com.example.myapplication.activity.week2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.activity.week2.fragment.DetailWeek2Fragment
import com.example.myapplication.activity.week2.fragment.EditWeek2Fragment
import com.example.myapplication.activity.week2.fragment.Week2Fragment

class Adapter(private val context: Week2Fragment, fm: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fm,lifecycle)  {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                DetailWeek2Fragment()
            }
            else -> {
                EditWeek2Fragment()
            }
        }
    }

}