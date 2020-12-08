package com.example.myapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class Week1Activity : AppCompatActivity() {

    private lateinit var edt_num1: TextView
    private lateinit var edt_num2: EditText
    private lateinit var txt_operator: TextView
    private lateinit var txt_answer: TextView


    var rdo_group: RadioGroup? = null
    private lateinit var rdo_string: RadioButton
    private lateinit var rdo_integer: RadioButton
    private lateinit var btn_answer: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week1)

        edt_num1 = findViewById(R.id.edt_num1)
        edt_num2 = findViewById(R.id.edt_num2)
        txt_operator = findViewById(R.id.txt_operator)
        txt_answer = findViewById(R.id.txt_answer)
        btn_answer = findViewById(R.id.btn_answer)

        btn_answer.setOnClickListener {
            var num1 = edt_num1.text.toString()
            var num2 = edt_num2.text.toString()

            rdo_string = findViewById(R.id.rdo_string)
            rdo_integer = findViewById(R.id.rdo_integer)


            if(num1 == "")
            {
                Toast.makeText(this, "Please Input Data", Toast.LENGTH_SHORT).show()
            }
            else if(num2 == "")
            {
                Toast.makeText(this,"Please Input Data",Toast.LENGTH_SHORT).show()
            }

            if (rdo_string.isChecked)
            {
                txt_answer.text = "Answer is : "+num1 + num2
            }
            else
            {
                edt_num1.text =""
                edt_num2.setText("")
                if(num1 == edt_num1.text.toString() && num2 == edt_num2.text.toString())
                {
                    txt_answer.text = "Answer is : ${num1 + num2} "
                }
                else {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("WARNING")
                    builder.setMessage("Please Can only enter numbers Do not enter letters")
                    builder.setPositiveButton("OK"){Dialog, which ->
                        Toast.makeText(applicationContext," Please correct ",Toast.LENGTH_SHORT).show()
                    }
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                }
            }
        }

    }


}