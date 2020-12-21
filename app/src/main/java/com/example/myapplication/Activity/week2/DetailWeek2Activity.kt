package com.example.myapplication.activity.week2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class DetailWeek2Activity : AppCompatActivity() {

    private lateinit var tvFirstname: TextView
    private lateinit var tvLastname: TextView
    private lateinit var tvTelephone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_week2)

        settingID()
        intentData()
        //intentUpdate()
    }


    private fun intentData(){
        try {
            val user = intent.getParcelableExtra<User>("user") as User
            var (firstname, lastname, telephone) = user

            tvFirstname.text = firstname
            tvLastname.text = lastname
            tvTelephone.text = telephone
        }
        catch (ex: Exception){
            dialogAlert("${ex}")
        }
    }
    /*fun intentUpdate(){
        try {
            val updateUser = intent.getParcelableExtra<User>("update") as User
            var (firstname, lastname, telephone) = updateUser
            tvFirstname.text = firstname
            tvLastname.text = lastname
            tvTelephone.text = telephone
        }
        catch (e : Exception){
            dialogAlert("${e}")
        }
    }*/

    private fun settingID(){
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
                var intent = Intent(this, EditProfileActivity::class.java)
                val firstName = tvFirstname.text.toString()
                val lastName = tvLastname.text.toString()
                val telephone = tvTelephone.text.toString()
                val user = User(firstName,lastName,telephone)
                intent.putExtra("update",user)
                startActivity(intent)
            }
        }
        return true
    }

    private fun dialogAlert(textMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage(textMassage)
        builder.setPositiveButton("OK") { Dialog, which ->

        }
        val dialog: AlertDialog = builder.create()
        dialog.show()



    }
}
