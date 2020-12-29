package com.example.myapplication.week2.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R


class Week2Fragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etTelNo: EditText
    private lateinit var btnRegister: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_week2, container, false)

    }

    private fun bindDingView(){
        btnRegister = view?.findViewById(R.id.btnRegister)!!
        etName = view?.findViewById(R.id.etName)!!
        etLastName = view?.findViewById(R.id.etLastName)!!
        etTelNo = view?.findViewById(R.id.etTelNo)!!
        btnRegister = view?.findViewById(R.id.btnRegister)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            view.findViewById<Button>(R.id.btnRegister).setOnClickListener {
                register()
            }
    }

    private fun register() {
        bindDingView()
        val firstName = etName.text.toString()
        val lastName = etLastName.text.toString()
        val telephone = etTelNo.text.toString()
        val intent = Intent(context, DetailWeek2Activity::class.java)
        val user = User(firstName, lastName, telephone)
        intent.putExtra("user", user)
        if (firstName.isNullOrEmpty() || lastName.isNullOrEmpty() || telephone.isNullOrEmpty()) {
            dialogAlert( getString(R.string.msgError))
        } else {
            startActivity(intent)

        }
    }


    private fun dialogAlert(errorMassage: String) {
        val builder = android.app.AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.msgTitleDialog))
        builder.setMessage(errorMassage)
        builder.setPositiveButton(getString(R.string.msgButtonDialog)) { _, _ ->
            Toast.makeText(context, getString(R.string.msgToastDialog), Toast.LENGTH_SHORT).show()
        }
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }
}
