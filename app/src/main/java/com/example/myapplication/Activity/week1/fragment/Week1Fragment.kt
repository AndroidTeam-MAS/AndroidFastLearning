package com.example.myapplication.activity.week1.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.myapplication.R


class Week1Fragment : Fragment() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvOperator: TextView
    private lateinit var tvAnswer: TextView
    var rgGroup: RadioGroup? = null
    private lateinit var rbString: RadioButton
    private lateinit var rbInteger: RadioButton
    private lateinit var btAnswer: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_week1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        answer()
    }

    private fun answer() {
        view?.findViewById<Button>(R.id.btAnswer)?.setOnClickListener {
            val num1 = view?.findViewById<EditText>(R.id.etNumber1)
            val num2 = view?.findViewById<EditText>(R.id.etNumber2)
            val rbString = view?.findViewById<RadioButton>(R.id.rbString)
            val rbInteger = view?.findViewById<RadioButton>(R.id.rbInteger)
            val tvAnswer = view?.findViewById<TextView>(R.id.tvAnswer)
            if (num1?.text.isNullOrEmpty()) {
                dialogAlert(false,getString(R.string.msgEdittextEmpty))
            } else if (num2?.text.isNullOrEmpty()) {
                dialogAlert(false,"Please enter your numbers.")
            } else if (rbString?.isChecked == false && rbInteger?.isChecked == false){
                dialogAlert(false,getString(R.string.msgSelectRadio))
            }
            if (rbString?.isChecked == true) {
                tvAnswer?.text = "Answer is : " + num1?.text + num2?.text
            } else if (rbInteger?.isChecked == true) {
                if (num1?.text.toString().toIntOrNull() ?: true == true &&
                    num2?.text.toString().toIntOrNull() ?: true == true
                ) {
                    dialogAlert(true,getString(R.string.msgWeek1error))
                } else {
                    tvAnswer?.text = "Answer is : " + (num1?.text.toString().toInt() + num2?.text.toString().toInt())
                }
            }
        }
    }
    private fun checkAns() {
        if (etNumber1.text.isEmpty()) {
            dialogAlert(false,getString(R.string.msgEdittextEmpty))
        } else if (etNumber2.text.isEmpty()) {
            dialogAlert(false,"Please enter your numbers.")
        } else if (rbString.isChecked == false && rbInteger.isChecked == false){
            dialogAlert(false,getString(R.string.msgSelectRadio))
        }

    }
    private fun dialogAlert(isCatch: Boolean ,errorMassage: String) {
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