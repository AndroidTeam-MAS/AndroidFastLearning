package com.example.myapplication.activity.week2.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.activity.week2.User

class DetailWeek2Fragment : Fragment() {
    private lateinit var tvFirstname: TextView
    private lateinit var tvLastname: TextView
    private lateinit var tvTelephone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_week2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intentData()
    }

    private fun intentData(){
        try {
            val user = Intent().getParcelableExtra<User>("user") as User
            var (firstname, lastname, telephone) = user

            tvFirstname.text = firstname
            tvLastname.text = lastname
            tvTelephone.text = telephone
        }
        catch (ex: Exception){
            dialogAlert("${ex}")
        }
    }

    private fun dialogAlert(textMassage: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("WARNING")
        builder.setMessage(textMassage)
        builder.setPositiveButton("OK") { Dialog, which ->

        }
        val dialog: AlertDialog = builder.create()
        dialog.show()



    }

}