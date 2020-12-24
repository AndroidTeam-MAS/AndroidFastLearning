package com.example.myapplication.activity.week2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.R
import com.example.myapplication.activity.week2.fragment.DetailWeek2Fragment
import com.example.myapplication.activity.week2.fragment.Week2Fragment

class Adapter(private val context: Context, fm: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fm,lifecycle)  {
    val tabText: Array<String> = arrayOf(*context.resources.getStringArray(R.array.tab_title))

    override fun getItemCount() = tabText.size

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> {
                Week2Fragment()
            }
            else -> {
                DetailWeek2Fragment()
            }
        }
    }

}