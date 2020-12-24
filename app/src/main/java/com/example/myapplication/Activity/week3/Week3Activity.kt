package com.example.myapplication.activity.week3

import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.activity.MainTabActivity
import com.example.myapplication.activity.PREF_KEY_LOGIN
import com.example.myapplication.activity.PREF_KEY_USERNAME
import com.example.myapplication.databinding.ActivityWeek3Binding
import com.pixplicity.easyprefs.library.Prefs


class Week3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityWeek3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week3)
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
        if (Prefs.getBoolean(PREF_KEY_LOGIN, false)){
            nextPage()
        }else {
            binding = ActivityWeek3Binding.inflate(layoutInflater)
            setContentView(binding.root)
            setupWidget()
        }
    }

    private fun nextPage(){
        Intent(this,MainTabActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }

    fun setupWidget(){
        binding.btnLogin.setOnClickListener {
            validate()
        }

        binding.ScrollLogin.apply {

        }
    }

    private fun validate(){
        var username = binding.etLogin.text.toString()
        var password = binding.etPassword.text.toString()

        if (username.isEmpty() || password.isEmpty()){
            dialogAlert(false,getString(R.string.msgWeek3UserPass))
            return
        }
        if (username == "test" && password == "test"){
            Prefs.putBoolean(PREF_KEY_LOGIN, true)
            Prefs.putString(PREF_KEY_USERNAME, username)
            nextPage()
        }
    }

    private fun dialogAlert(isCatch: Boolean ,errorMassage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage(errorMassage)
        builder.setPositiveButton("OK") { Dialog, which ->
            Toast.makeText(this, " Please correct ", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}