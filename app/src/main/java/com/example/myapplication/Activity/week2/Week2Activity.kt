package com.example.myapplication.activity.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class Week2Activity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etTelNo: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week2)
        setiingID()
        register()
    }


   private fun setiingID(){
        etName = findViewById(R.id.etName)
        etLastName = findViewById(R.id.etLastName)
        etTelNo = findViewById(R.id.etTelNo)
        btnRegister = findViewById(R.id.btnRegister)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    private fun checkEmpty() {
        if (etName.text.equals("")) {
            dialogAlert(getString(R.string.msgError))
            //etName.setError("Please enter your firstname")
        }
        else if (etLastName.text.equals("")) {
            dialogAlert(getString(R.string.msgErrorLastName)) // แก้
            //etLastName.setError("Please enter your lastname")
        }
        else if (etTelNo.text.equals("")) {
            dialogAlert(getString(R.string.msgErrorNumber))
            //etTelNo.setError("Please enter your telephone number")
        }
    }

     private fun dialogAlert(errorMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage(errorMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
            Toast.makeText(applicationContext, " Please enter your Personal information ", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun register(){
        btnRegister.setOnClickListener {
            val firstname = etName.text.toString()
            val lastname = etLastName.text.toString()
            val telephone = etTelNo.text.toString()
            val intent = Intent(this, DetailWeek2Activity::class.java)
            val user = User(firstname,lastname,telephone)
            intent.putExtra("user",user)
            if (etName.text.isNullOrEmpty() || etLastName.text.isNullOrEmpty() || etTelNo.text.isNullOrEmpty()) {
                dialogAlert(getString(R.string.msgError))

            }
            else{
                startActivity(intent)
                finish()
            }
        }
    }

}




