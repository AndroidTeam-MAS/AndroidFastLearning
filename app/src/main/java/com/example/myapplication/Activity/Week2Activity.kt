package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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

        register()
    }

    fun setiingID(){
        etName = findViewById(R.id.etName)
        etLastName = findViewById(R.id.etLastName)
        etTelNo = findViewById(R.id.etTelNo)
        btnRegister = findViewById(R.id.btnRegister)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    fun checkEmpty() {
        if (etName.toString().equals("")) {
            dialogAlert("Please enter your firstname")
            //etName.setError("Please enter your firstname")
        }
        else if (etLastName.toString().equals("")) {
            dialogAlert("Please enter your lastname")
            //etLastName.setError("Please enter your lastname")
        }
        else if (etTelNo.toString().equals("")) {
            dialogAlert("Please enter your telephone number")
            //etTelNo.setError("Please enter your telephone number")
        }

    }

    fun dialogAlert(errorMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage(errorMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
            Toast.makeText(applicationContext, " Please enter your Personal information ", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun register(){
        btnRegister.setOnClickListener {
            checkEmpty()
            var firstName = etName.text.toString().trim()
            var lastName = etLastName.text.toString().trim()
            var telephone = etTelNo.text.toString().trim()




        }
    }

    override fun onStart() {
        super.onStart()
    }
}