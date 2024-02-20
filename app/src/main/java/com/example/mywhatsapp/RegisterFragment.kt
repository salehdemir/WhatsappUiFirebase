package com.example.mywhatsapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.mywhatsapp.CustomApp.Companion.auth
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_register, container, false)

        val tvLog = rootView.findViewById<TextView>(R.id.tvLog)
        val emailRegister = rootView.findViewById<EditText>(R.id.emailRegister)
        val passwordRegister = rootView.findViewById<EditText>(R.id.passwordRegister)
        val progressBar = rootView.findViewById<ProgressBar>(R.id.progressBar)
        val Btn = rootView.findViewById<Button>(R.id.btnRegister)
//        ASK
        auth = CustomApp.auth

        tvLog.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        Btn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val email = emailRegister.text.toString()
            val password = passwordRegister.text.toString()

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    progressBar.visibility = View.GONE
                    if (it.isSuccessful) {
                        SharedPreferencesHelper.saveLoginStatus(requireContext(), true)
                        findNavController().navigate(R.id.action_registerFragment_to_mainActivity)
                    }
                }.addOnFailureListener {
//                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }
        return rootView
    }
}