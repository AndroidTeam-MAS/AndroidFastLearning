package com.example.myapplication.week2.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class EditProfileActivity : AppCompatActivity() {

//    private lateinit var tvOldName: TextView
//    private lateinit var etFirstname: EditText
//    private lateinit var tvOldLastName: TextView
//    private lateinit var etLastname: EditText
//    private lateinit var tvOldNumber: TextView
//    private lateinit var etTelephone: EditText
//    private lateinit var btnEdit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        //intentData()
    }
//    private fun intentData(){
//        try {
//            val user = intent.getParcelableExtra<User>("update") as User
//            var (firstName, lastName, telephone) = user
//
//            val fragmentWeek2Edit: EditWeek2Fragment = EditWeek2Fragment.newInstance(
//                firstName = firstName,
//                lastName = lastName,
//                number = telephone
//            )
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.add(R.id.flEditWeek2, fragmentWeek2Edit)
//            fragmentTransaction.commit()
//
//        }
//        catch (ex: Exception){
//            dialogAlert("${ex}")
//        }
//    }
//    private fun dialogAlert(textMassage: String) {
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("WARNING")
//        builder.setMessage(textMassage)
//        builder.setPositiveButton("OK") { Dialog, which ->
//        }
//        val dialog: AlertDialog = builder.create()
//        dialog.show()
//    }

}