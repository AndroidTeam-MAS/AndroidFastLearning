package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var btn_week1: Button
    private lateinit var btn_week2: Button
    private lateinit var btn_week3: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_week1 = findViewById(R.id.btn_week1)
        btn_week2 = findViewById(R.id.btn_week2)

        btn_week1.setOnClickListener {
            var intent = Intent(this, Week1Activity::class.java)
            startActivity(intent)
        }

        btn_week2.setOnClickListener {
            var intent = Intent(this, Week2Activity::class.java)
            startActivity(intent)
        }



    }
}

