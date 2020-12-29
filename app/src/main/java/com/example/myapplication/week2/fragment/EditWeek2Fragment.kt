package com.example.myapplication.week2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class EditWeek2Fragment : Fragment() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etTelephone: EditText
    private lateinit var btnEdit: Button
    private var firstname: String? = null
    private var lastname: String? = null
    private var number: String? = null

    companion object {
        const val EXTRA_FIRSTNAME = "extra_firstName"
        const val EXTRA_LASTNAME = "extra_lastName"
        const val EXTRA_NUMBER = "extra_number"

        fun newInstance(firstName: String?, lastName: String?, number: String?): EditWeek2Fragment {
            return EditWeek2Fragment().apply {
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
            firstname = bundle.getString(EXTRA_FIRSTNAME)
            lastname = bundle.getString(EXTRA_LASTNAME)
            number = bundle.getString(EXTRA_NUMBER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_week2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
        btnEdit.apply {
            setOnClickListener {
                updateInformation()
            }
        }
    }

    private fun bindDingView() {
        btnEdit = view?.findViewById(R.id.btnEdit)!!
        etFirstName = view?.findViewById(R.id.etFirstName)!!
        etLastName = view?.findViewById(R.id.etLastName)!!
        etTelephone = view?.findViewById(R.id.etTelephone)!!
        btnEdit = view?.findViewById(R.id.btnEdit)!!
    }
    private fun setText() {
        bindDingView()
        etFirstName.setText(firstname)
        etLastName.setText(lastname)
        etTelephone.setText(number)
    }
    private fun updateInformation() {
        bindDingView()
        if (etFirstName.text.isNullOrEmpty() || etLastName.text.isNullOrEmpty() || etTelephone.text.isNullOrEmpty()){}
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val telephone = etTelephone.text.toString().trim()
        val fragmentWeek2: DetailWeek2Fragment = DetailWeek2Fragment.newInstance(
            firstName = firstName,
            lastName = lastName,
            number = telephone
        )
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.flDetailWeek2, fragmentWeek2)
            ?.addToBackStack(null)
        fragmentTransaction?.commit()


    }
}