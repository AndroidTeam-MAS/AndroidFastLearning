package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R.id.nav_item_one
import com.example.myapplication.adapter.MyAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navView)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val pagerAdapter = MyAdapter(supportFragmentManager)

        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        val dotsIndicator = findViewById<WormDotsIndicator>(R.id.dotViewPager)
        dotsIndicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(
            object: ViewPager.OnPageChangeListener{
                override fun onPageSelected(position: Int) {
                    val str = "page ${position +1}"
                    Toast.makeText(baseContext,str,Toast.LENGTH_SHORT).show()
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {}

                override fun onPageScrollStateChanged(state: Int) {}
            }
        )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        when (item.itemId) {
            nav_item_one -> {
                viewPager.currentItem = 0
            }
            R.id.nav_item_two -> {
                viewPager.currentItem = 1
                }
            }
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}