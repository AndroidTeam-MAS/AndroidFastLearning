package com.example.myapplication.activity.week1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.activity.week1.fragment.Week1Fragment

class Week1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week1)

        val fragmentWeek1 = Week1Fragment()
        val fragMan = supportFragmentManager
        val fragTrans = fragMan.beginTransaction()
        fragTrans.add(R.id.flWeek1, fragmentWeek1)
        fragTrans.commit()
    }
}