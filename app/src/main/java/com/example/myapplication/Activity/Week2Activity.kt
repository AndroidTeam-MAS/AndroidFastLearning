package com.example.myapplication.Activity

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

    fun setiingID(){
        etName = findViewById(R.id.etName)
        etLastName = findViewById(R.id.etLastName)
        etTelNo = findViewById(R.id.etTelNo)
        btnRegister = findViewById(R.id.btnRegister)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    fun checkEmpty() {
        if (etName.text.equals("")) {
            dialogAlert("Please enter your firstname")
            //etName.setError("Please enter your firstname")
        }
        else if (etLastName.text.equals("")) {
            dialogAlert("Please enter your lastname")
            //etLastName.setError("Please enter your lastname")
        }
        else if (etTelNo.text.equals("")) {
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
        checkEmpty()
        btnRegister.setOnClickListener {
            var firstname = etName.text.toString()
            var lastname = etLastName.text.toString()
            var telephone = etTelNo.text.toString()
            //var user = User(etName.toString(),etLastName.toString(),etTelNo.toString())
            var intent = Intent(this, DetailWeek2::class.java)

            val user = userClass(firstname,lastname,telephone)
            intent.putExtra("user",user)
            startActivity(intent)
        }
    }

}
data class User(var firstname: String, var lastname: String, var phonenumber: String)




