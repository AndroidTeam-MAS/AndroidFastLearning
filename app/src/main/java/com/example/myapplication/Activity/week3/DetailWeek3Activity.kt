package com.example.myapplication.activity.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDetailWeek2Binding.inflate
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragment.FragmentThree
import com.example.myapplication.fragment.FragmentTwo
import com.example.myapplication.fragment.Tab_week3_Fragment

class DetailWeek3Activity : AppCompatActivity() {

    private lateinit var binding: DetailWeek3Activity
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_week3)

        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)



        button2.setOnClickListener {
            showFragment(Tab_week3_Fragment())
        }
        button3.setOnClickListener {
            showFragment(FragmentTwo())
        }
        button4.setOnClickListener {
            showFragment(FragmentThree())
        }

    }

    fun showFragment(fm : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fm)
            .commit()
    }



}