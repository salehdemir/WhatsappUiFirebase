package com.example.mywhatsapp

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.mywhatsapp.CustomApp.Companion.auth
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        val tvReg = rootView.findViewById<TextView>(R.id.tvReg)
        val emailLogin = rootView.findViewById<EditText>(R.id.emailLogin)
        val passwordLogin = rootView.findViewById<EditText>(R.id.passwordLogin)
        val progressBar = rootView.findViewById<ProgressBar>(R.id.progressBar)
        val Btn = rootView.findViewById<Button>(R.id.btnLogin)
        auth = auth

        tvReg.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        Btn.setOnClickListener {

            progressBar.visibility = View.VISIBLE
            val email = emailLogin.text.toString()
            val password = passwordLogin.text.toString()


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    progressBar.visibility = View.GONE
                    if (it.isSuccessful) {

                        SharedPreferencesHelper.saveLoginStatus(requireContext(), true)
                        findNavController().navigate(R.id.action_loginFragment_to_mainActivity)

                    }
                }
                .addOnFailureListener {
//                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }


        return rootView
    }


}