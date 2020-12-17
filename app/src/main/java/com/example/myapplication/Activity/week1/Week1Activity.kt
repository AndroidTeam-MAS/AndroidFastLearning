package com.example.myapplication.activity.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class Week1Activity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var tvOperator: TextView
    private lateinit var tvAnswer: TextView
    var rgGroup: RadioGroup? = null
    private lateinit var rbString: RadioButton
    private lateinit var rbInteger: RadioButton
    private lateinit var btAnswer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week1)
        findByID()
        answer()
    }

    private fun findByID() {

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvOperator = findViewById(R.id.tvOperator)
        tvAnswer = findViewById(R.id.tvAnswer)
        btAnswer = findViewById(R.id.btAnswer)
        rbString = findViewById(R.id.rbString)
        rbInteger = findViewById(R.id.rbInteger)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun dialogAlert(isCatch: Boolean ,errorMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage(errorMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
            Toast.makeText(applicationContext, " Please correct ", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun answer() {
        btAnswer.setOnClickListener {
            checkAns()
            var num1 = etNumber1.text.toString()
            var num2 = etNumber2.text.toString()
            if (rbString.isChecked) {
                tvAnswer.text = "Answer is : " + num1 + num2
            }
            else if (rbInteger.isChecked) {
                if (num1.toIntOrNull() ?: true == true &&
                        num2.toIntOrNull() ?: true == true) {
                    dialogAlert(true,"Please enter numbers only.")
                }
                else {
                    tvAnswer.text = "Answer is : " + (num1.toInt() + num2.toInt())
                }
            }
        }
    }

    private fun checkAns() {
        if (etNumber1.text.isEmpty()) {
            dialogAlert(false,"Please enter your numbers.")
        } else if (etNumber2.text.isEmpty()) {
            dialogAlert(false,"Please enter your numbers.")
        } else if (rbString.isChecked == false && rbInteger.isChecked == false){
            dialogAlert(false,"Please select datatype")
        }
    }
}