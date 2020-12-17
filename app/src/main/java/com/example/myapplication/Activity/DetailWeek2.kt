package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.myapplication.R

class DetailWeek2 : AppCompatActivity() {

    private lateinit var tvFirstname: TextView
    private lateinit var tvLastname: TextView
    private lateinit var tvTelephone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_week2)

        settingID()

       val user = intent.getParcelableExtra<User>("user") as User
        var (firstname, lastname, telephone) = user

        tvFirstname.text = firstname
        tvLastname.text = lastname
        tvTelephone.text = telephone


    }


    fun settingID(){
        tvFirstname = findViewById(R.id.tvFirstname)
        tvLastname = findViewById(R.id.tvLastname)
        tvTelephone = findViewById(R.id.tvTelephone)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        if (item != null) {
            if (item.itemId == R.id.menu_setting) {
                var intent = Intent(this, EditProfile::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}