package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding.inflate
import java.time.Instant

class MainActivity : AppCompatActivity() {

    private lateinit var btn_week1: Button
    private lateinit var btn_week2: Button
    private lateinit var btn_week3: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_week1 = findViewById(R.id.btn_week1)

        btn_week1.setOnClickListener {
            var intent = Intent(this, Week1Activity::class.java)
            startActivity(intent)
        }



    }
}

