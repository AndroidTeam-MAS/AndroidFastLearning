package com.example.myapplication.activity.week2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.activity.week2.fragment.Week2Fragment

class Week2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week2)

        val fragmentWeek2 = Week2Fragment()
        val fragMan = supportFragmentManager
        val fragTrans = fragMan.beginTransaction()
        fragTrans.add(R.id.flWeek2, fragmentWeek2)
        fragTrans.commit()
    }
}




