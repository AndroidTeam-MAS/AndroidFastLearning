package com.example.myapplication.week2.fragment

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.fragment.Week1Fragment
import com.example.myapplication.week2.fragment.DetailWeek2Fragment.Companion.newInstance

class Week2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week2)
    }
}
