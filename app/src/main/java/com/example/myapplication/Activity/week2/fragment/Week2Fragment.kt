package com.example.myapplication.activity.week2.fragment

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
import com.example.myapplication.activity.week2.DetailWeek2Activity
import com.example.myapplication.activity.week2.User


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnRegister).apply {
            setOnClickListener {
               register()
            }
        }

    }

    private fun checkEmpty() {
        if (etName.text.equals("")) {
            dialogAlert(false,getString(R.string.msgError))
            //etName.setError("Please enter your firstname")
        }
        else if (etLastName.text.equals("")) {
            dialogAlert(false,getString(R.string.msgErrorLastName)) // แก้
            //etLastName.setError("Please enter your lastname")
        }
        else if (etTelNo.text.equals("")) {
            dialogAlert(false,getString(R.string.msgErrorNumber))
            //etTelNo.setError("Please enter your telephone number")
        }
    }

    private fun register(){
            val firstname = view?.findViewById<EditText>(R.id.etName)?.text.toString()
            val lastname = view?.findViewById<EditText>(R.id.etLastName)?.text.toString()
            val telephone = view?.findViewById<EditText>(R.id.etTelNo)?.text.toString()
            val intent = Intent(context, DetailWeek2Activity::class.java)
            val user = User(firstname,lastname,telephone)
            intent.putExtra("user",user)
            if (firstname.isNullOrEmpty() || lastname.isNullOrEmpty() || telephone.isNullOrEmpty()) {
                dialogAlert(false,getString(R.string.msgError))
            }
            else{
                startActivity(intent)

            }
        }
//    private fun register(){
//        view?.findViewById<Button>(R.id.btnRegister)?.setOnClickListener {
//            val firstname = <EditText>(R.id.etName)
//            val lastname = view?.findViewById<EditText>(R.id.etLastName)
//            val telephone = view?.findViewById<EditText>(R.id.etTelNo)
//            val intent = Intent(context, DetailWeek2Activity::class.java)
//            val user = User(firstname,lastname,telephone)
//            intent.putExtra("user",user)
//            if (firstname.text.isNullOrEmpty() || lastname.text.isNullOrEmpty() || telephone.text.isNullOrEmpty()) {
//                dialogAlert(false,getString(R.string.msgError))
//                //etName.setError("Please enter your firstname")
//            }
//            else{
//                requireActivity().run {
//                    startActivity(Intent(this, DetailWeek2Activity::class.java))
//                    finish()
//                }
//            }
//        }
//    }

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
}

