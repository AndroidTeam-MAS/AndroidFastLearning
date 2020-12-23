package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.activity.week1.Week1Activity
import com.example.myapplication.activity.week2.Week2Activity
import com.example.myapplication.activity.week3.Week3Activity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnWeek1.setOnClickListener {
            var intent = Intent(this, Week1Activity::class.java)
            startActivity(intent)
        }

        binding.btnWeek2.setOnClickListener {
            var intent = Intent(this, Week2Activity::class.java)
            startActivity(intent)
        }

        binding.btnWeek3.setOnClickListener {
            var intent = Intent(this,Week3Activity::class.java)
            startActivity(intent)
        }
    }
}

