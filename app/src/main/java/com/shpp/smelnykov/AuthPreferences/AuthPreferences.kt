package com.shpp.smelnykov.AuthPreferences

import android.content.Context

object AuthPreferences {
    /**
     * Constant for email key
     * */
    private const val EMAIL_AUTH_KEY = "email"

    /**
     * Constant for password key
     * */
    private const val PASSWORD_AUTH_KEY = "password"

    /**
     * Preference for SharedPreferences
     * */
    private const val AUTOLOGIN_PREFERENCE = "AUTOLOGIN_PREFERENCE"

    fun saveCredentials(context: Context, email: String, password: String) {
        val sharedPreferences = context.getSharedPreferences(AUTOLOGIN_PREFERENCE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(EMAIL_AUTH_KEY, email)
        editor.putString(PASSWORD_AUTH_KEY, password)
        editor.apply()
    }

    fun clearData(context: Context) {
        val sharedPreferences = context.getSharedPreferences(AUTOLOGIN_PREFERENCE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun isUserLoggedIn(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(AUTOLOGIN_PREFERENCE, Context.MODE_PRIVATE)
        return sharedPreferences.contains(EMAIL_AUTH_KEY)
    }

    fun getUserEmail(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(AUTOLOGIN_PREFERENCE, Context.MODE_PRIVATE)
        return sharedPreferences.getString(EMAIL_AUTH_KEY, null)
    }

    fun getUserPassword(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(AUTOLOGIN_PREFERENCE, Context.MODE_PRIVATE)
        return sharedPreferences.getString(PASSWORD_AUTH_KEY, null)
    }
}