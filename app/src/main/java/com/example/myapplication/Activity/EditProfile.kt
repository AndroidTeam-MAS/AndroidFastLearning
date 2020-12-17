package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class EditProfile : AppCompatActivity() {

    lateinit var tvOldName: TextView
    lateinit var etFirstname: EditText
    lateinit var tvOldLastName: TextView
    lateinit var etLastname: EditText
    lateinit var tvOldNumber: TextView
    lateinit var etTelephone: EditText
    lateinit var btnEdit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        settingID()
        updateInformation()

    }
    fun settingID(){
        tvOldName = findViewById(R.id.tvOldName)
        etFirstname = findViewById(R.id.etFirstname)
        tvOldLastName = findViewById(R.id.tvOldLastName)
        etLastname = findViewById(R.id.etLastname)
        tvOldNumber = findViewById(R.id.tvOldNumber)
        etTelephone = findViewById(R.id.etTelephone)
        btnEdit = findViewById(R.id.btnEdit)
    }
    fun updateInformation(){
        btnEdit.setOnClickListener {
            var _firstname = etFirstname.text.toString()
            var _lastname = etLastname.text.toString()
            var _telephone = etTelephone.text.toString()
            var intent = Intent(this,DetailWeek2::class.java)
            var user = User(_firstname,_lastname,_telephone)
            intent.putExtra("update",user)
            startActivity(intent)
            finish()
        }
    }
    fun dialogAlert(textMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage(textMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}