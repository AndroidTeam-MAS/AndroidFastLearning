package com.example.myapplication.week2.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import org.w3c.dom.Text

class DetailWeek2Fragment : Fragment() {


    private lateinit var tvFirstName : TextView
    private lateinit var tvLastName : TextView
    private lateinit var tvTelephone : TextView
    private var firstName: String? = null
    private var lastName: String? = null
    private var number: String? = null


    companion object {
        const val EXTRA_FIRSTNAME = "extra_firstname"
        const val EXTRA_LASTNAME = "extra_lastname"
        const val EXTRA_NUMBER = "extra_number"

        fun newInstance(firstName: String?,lastName: String?, number: String?): DetailWeek2Fragment {
            return DetailWeek2Fragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FIRSTNAME, firstName)
                    putString(EXTRA_LASTNAME, lastName)
                    putString(EXTRA_NUMBER, number)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle: Bundle ->
            firstName = bundle.getString(EXTRA_FIRSTNAME)
            lastName = bundle.getString(EXTRA_LASTNAME)
            number = bundle.getString(EXTRA_NUMBER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_week2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showText()
    }
    private fun bindDingView(){
        tvFirstName = view?.findViewById(R.id.tvFirstname)!!
        tvLastName = view?.findViewById(R.id.tvLastname)!!
        tvTelephone = view?.findViewById(R.id.tvTelephone)!!
    }
    private fun showText(){
        bindDingView()
        tvFirstName.setText(firstName)
        tvLastName.setText(lastName)
        tvTelephone.setText(number)
    }


}