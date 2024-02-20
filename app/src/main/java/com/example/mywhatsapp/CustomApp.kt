package com.example.mywhatsapp

import android.app.Application
import com.google.firebase.auth.FirebaseAuth

class CustomApp:Application() {



    override fun onCreate() {
        super.onCreate()
        auth = FirebaseAuth.getInstance()
    }
    companion object {
        lateinit var auth: FirebaseAuth
    }

}