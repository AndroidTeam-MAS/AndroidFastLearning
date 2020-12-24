package com.example.myapplication.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.activity.ui.main.SectionsPagerAdapter
import com.example.myapplication.databinding.ActivityMainTabBinding
import com.example.myapplication.databinding.CustomTabMenuBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class MainTabActivity : AppCompatActivity() {

    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var binding: ActivityMainTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainTabBinding.inflate(layoutInflater)

        setContentView(binding.root)
        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, lifecycle)
        setupViewPager()
        setupWidget()
        setupTab()

    }



    private fun setupTab() {
        TabLayoutMediator(binding.tabs, binding.viewPager,
            TabLayoutMediator.TabConfigurationStrategy { xTab, xPosition ->
                val binding = CustomTabMenuBinding.inflate(layoutInflater)
                binding.tabWeek1.text = (sectionsPagerAdapter.tabText[xPosition])
                xTab.customView = binding.root
            }).attach()
    }

    private fun setupWidget() {
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = sectionsPagerAdapter
        }.also {
            it.setPageTransformer(HorizontalFlipTransformation())
            it.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0) {
                        binding.fab.visibility = View.INVISIBLE
                    } else {
                        binding.fab.visibility = View.INVISIBLE
                    }
                }
            })
        }
    }

}