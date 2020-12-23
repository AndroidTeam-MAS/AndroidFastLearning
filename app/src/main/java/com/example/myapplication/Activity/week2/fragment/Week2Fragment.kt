package com.example.myapplication.activity.week2.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.activity.week2.Adapter
import com.example.myapplication.activity.week2.User
import com.example.myapplication.databinding.FragmentWeek2Binding


class Week2Fragment : Fragment() {


    private lateinit var adapter: Adapter
    private lateinit var binding: FragmentWeek2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_week2, container, false)
        register()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentWeek2Binding.inflate(layoutInflater)
    }
    private fun dialogAlert(isCatch: Boolean, errorMassage: String) {
        val builder = android.app.AlertDialog.Builder(context)
        builder.setTitle("WARNING")
        builder.setMessage(errorMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
            Toast.makeText(context, " Please correct ", Toast.LENGTH_SHORT).show()
        }
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }

    private fun register(){
       binding.btnRegister.setOnClickListener {
            val firstname = binding.etName.text.toString()
            val lastname = binding.etLastName.text.toString()
            val telephone = binding.etTelNo.text.toString()
            val intent = Intent(context, DetailWeek2Fragment::class.java)
            val user = User(firstname, lastname, telephone)
            intent.putExtra("user", user)
            if (binding.etName.text.isNullOrEmpty() || binding.etLastName.text.isNullOrEmpty() || binding.etTelNo.text.isNullOrEmpty()) {
                dialogAlert(false, getString(R.string.msgError))

            }
            else{

            }
        }
    }
}