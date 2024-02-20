package com.example.mywhatsapp

import android.content.Context

object SharedPreferencesHelper {

    private const val PREF_FILE_NAME = "MyPrefs"
    private const val KEY_IS_LOGGED_IN = "isLoggedIn"

    fun saveLoginStatus(context: Context, isLoggedIn: Boolean) {
        val sharedPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun isLoggedIn(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

}
