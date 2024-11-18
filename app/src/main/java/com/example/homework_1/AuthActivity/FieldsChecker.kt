package com.example.homework_1.AuthActivity

import android.widget.EditText

/**
 * Class for checking email and passwords fields.
 * */
class FieldsChecker {

    /**
     * Method checks validation email and passwords.
     * @param editTextEmail EditText with email
     * @param editTextPassword EditText with password
     * @return True or False
     * */
    fun checkAllFields(editTextEmail: EditText?, editTextPassword: EditText?): Boolean {
        //Regex for email.
        val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

        //Regex for password. Minimum eight characters, at least one letter and one number
        val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")

        if (editTextEmail!!.length() == 0) {
            editTextEmail!!.error = "This field is required"
            return false
        }
        if (!emailRegex.matches(editTextEmail!!.text.toString())) {
            editTextEmail!!.error = "Incorrect email"
            return false
        }
        if (editTextPassword!!.length() == 0) {
            editTextPassword!!.error = "This field is required"
            return false
        }
        if (!passwordRegex.matches(editTextPassword!!.text.toString())) {
            editTextPassword!!.error = "Password could contains at least:\n\t8 characters" +
                    "\n\tone letter and one number"
            return false
        }
        return true
    }
}