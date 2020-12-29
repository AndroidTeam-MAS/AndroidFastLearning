package com.example.myapplication.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class Week1Fragment : Fragment() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvAnswer: TextView
    private lateinit var rbString: RadioButton
    private lateinit var rbInteger: RadioButton
    private lateinit var btAnswer: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        answerForWeek1()
    }

    private fun bindDingView() {
        etNumber1 = view?.findViewById(R.id.etNumber1)!!
        etNumber2 = view?.findViewById(R.id.etNumber2)!!
        rbString = view?.findViewById(R.id.rbString)!!
        rbInteger = view?.findViewById(R.id.rbInteger)!!
        tvAnswer = view?.findViewById(R.id.tvAnswer)!!
        btAnswer = view?.findViewById(R.id.btAnswer)!!
    }

    private fun answerForWeek1() {
        view?.findViewById<Button>(R.id.btAnswer)?.setOnClickListener {
            bindDingView()
            if (etNumber1.text.isNullOrEmpty()) {
                dialogAlert( getString(R.string.msgEdittextEmpty))
            } else if (etNumber2.text.isNullOrEmpty()) {
                dialogAlert( "Please enter your numbers.")
            } else if (!rbString.isChecked && !rbInteger.isChecked) {
                dialogAlert( getString(R.string.msgSelectRadio))
            }
            if (rbString.isChecked) {
                tvAnswer.text = "Answer is : " + etNumber1.text + etNumber2.text
            } else if (rbInteger.isChecked) {
                if (etNumber1.text.toString().toIntOrNull() ?: true == true &&
                    etNumber2.text.toString().toIntOrNull() ?: true == true
                ) {
                    dialogAlert( getString(R.string.msgWeek1error))
                } else {
                    var answerWeek1 = (etNumber1.text.toString().toInt() + etNumber2.text.toString()
                        .toInt())
                    tvAnswer.text =
                        "Answer is : $answerWeek1"
                }
            }
        }
    }

    private fun dialogAlert(errorMassage: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("WARNING")
        builder.setMessage(errorMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
            Toast.makeText(context, " Please correct ", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}