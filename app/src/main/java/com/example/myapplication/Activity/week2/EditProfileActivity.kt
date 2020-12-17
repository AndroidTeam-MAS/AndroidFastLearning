package com.example.myapplication.activity.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class EditProfileActivity : AppCompatActivity() {

    private lateinit var tvOldName: TextView
    private lateinit var etFirstname: EditText
    private lateinit var tvOldLastName: TextView
    private lateinit var etLastname: EditText
    private lateinit var tvOldNumber: TextView
    private lateinit var etTelephone: EditText
    private lateinit var btnEdit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        settingID()
        intentData()
        updateInformation()

    }
    private fun intentData(){
        try {
            val user = intent.getParcelableExtra<User>("update") as User
            var (firstName, lastName, telephone) = user
            etFirstname.hint = firstName
            etLastname.hint = lastName
            etTelephone.hint = telephone
        }
        catch (ex: Exception){
            dialogAlert("${ex}")
        }
    }
    private fun settingID(){
        tvOldName = findViewById(R.id.tvOldName)
        etFirstname = findViewById(R.id.etFirstname)
        tvOldLastName = findViewById(R.id.tvOldLastName)
        etLastname = findViewById(R.id.etLastname)
        tvOldNumber = findViewById(R.id.tvOldNumber)
        etTelephone = findViewById(R.id.etTelephone)
        btnEdit = findViewById(R.id.btnEdit)
    }
    private fun updateInformation(){
        btnEdit.setOnClickListener {

            var firstName = etFirstname.text.toString().trim()
            var lastName = etLastname.text.toString().trim()
            var telephone = etTelephone.text.toString().trim()
            var intent = Intent(this, DetailWeek2Activity::class.java)
            var user = User(firstName,lastName,telephone)
            intent.putExtra("user",user)
            if (etFirstname.text.isNullOrEmpty() || etLastname.text.isNullOrEmpty() || etTelephone.text.isNullOrEmpty()) {
                dialogAlert(getString(R.string.msgError))
                //etName.setError("Please enter your firstname")
            }
            else{
                startActivity(intent)
                finish()
            }

        }
    }

    private fun checkEmpty() {

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