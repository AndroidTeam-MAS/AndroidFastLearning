package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.lang.Exception

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


        settingUI()
        Answer()

    }

    fun settingUI() {

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvOperator = findViewById(R.id.tvOperator)
        tvAnswer = findViewById(R.id.tvAnswer)
        btAnswer = findViewById(R.id.btAnswer)
        rbString = findViewById(R.id.rbString)
        rbInteger = findViewById(R.id.rbInteger)
    }

    fun Answer(){
        btAnswer.setOnClickListener {
            try {
                val num1 = etNumber1.text.toString()
                val num2 = etNumber2.text.toString()

                CheckAns()

                if (rbString.isChecked) {
                    tvAnswer.text = "Answer is : " + num1 + num2
                } else if (rbInteger.isChecked) {
                    tvAnswer.text = "Answer is : " + (num1.toInt() + num2.toInt())
                }
            }
            catch (e:Exception){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("WARNING")
                builder.setMessage("Do not enter letters Can only enter numbers")
                builder.setPositiveButton("OK"){Dialog, which ->
                    Toast.makeText(applicationContext," Please correct ",Toast.LENGTH_SHORT).show()
                    etNumber1.text.clear()
                    etNumber2.text.clear()
                    tvAnswer.setText("")
                    rbInteger.isChecked = false
                    rbString.isChecked = false
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
            finally {

            }
        }
    }
    fun CheckAns(){
        if(etNumber1.text.isEmpty())
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("WARNING")
            builder.setMessage("Please Input Your Number")
            builder.setPositiveButton("OK"){Dialog, which ->
                Toast.makeText(applicationContext," Please correct ",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        else if(etNumber2.text.isEmpty())
        {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("WARNING")
            builder.setMessage("Please Input Your Number")
            builder.setPositiveButton("OK"){Dialog, which ->
                Toast.makeText(applicationContext," Please correct ",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}