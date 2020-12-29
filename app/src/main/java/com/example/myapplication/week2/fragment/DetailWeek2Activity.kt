package com.example.myapplication.week2.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class DetailWeek2Activity : AppCompatActivity() {


    private lateinit var tvFirstName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvTelephone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_week2)
        intentData()
    }
    private fun intentData(){
        try {
            val user = intent.getParcelableExtra<User>("user") as User
            val (firstName, lastName, telephone) = user

            val fragmentWeek2: DetailWeek2Fragment = DetailWeek2Fragment.newInstance(
                firstName = firstName,
                lastName = lastName,
                number = telephone
            )
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.flDetailWeek2, fragmentWeek2)
                .addToBackStack(null)
            fragmentTransaction.commit()
        }
        catch (ex: Exception){
            dialogAlert("$ex")
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        bindDingView()
        if (item.itemId == R.id.menu_setting) {
            val user = intent.getParcelableExtra<User>("user") as User
            val (firstName, lastName, telephone) = user

            val fragmentWeek2: EditWeek2Fragment = EditWeek2Fragment.newInstance(
                firstName = firstName,
                lastName = lastName,
                number = telephone
            )
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.flDetailWeek2, fragmentWeek2)
                .addToBackStack(null)
            fragmentTransaction.commit()
        }
        return true
    }
    private fun bindDingView(){
        tvFirstName = findViewById(R.id.tvFirstname)
        tvLastName = findViewById(R.id.tvLastname)
        tvTelephone = findViewById(R.id.tvTelephone)
    }

    private fun dialogAlert(textMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.msgTitleDialog))
        builder.setMessage(textMassage)
        builder.setPositiveButton(getString(R.string.msgButtonDialog)) { _, _ ->
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}