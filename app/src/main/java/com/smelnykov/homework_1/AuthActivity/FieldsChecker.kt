package com.smelnykov.homework_1.AuthActivity

import android.util.Patterns

/**
 * Object for checking email and passwords fields.
 * */
class FieldsChecker {

    /**
     * Method checks validationpasswords.
     * @param editTextPassword EditText with password
     * @return True or False
     * */
    fun checkPassword(editTextPassword: String): Boolean {
        //Regex for password. Minimum eight characters
        val passwordRegex = Regex(".{${MIN_PASSWORD_LENGTH},}")
        if (passwordRegex.matches(editTextPassword)) {
            return true
        }
        return false
    }

    /**
     * Method checks validation email.
     * @param editTextEmail EditText with email
     * @return True or False
     * */
    fun checkEmail(editTextEmail: String): Boolean {
        //Pattern for email.
        val emailPattern = Patterns.EMAIL_ADDRESS

        if (emailPattern.matcher(editTextEmail).matches()) {
            return true
        }
        return false
    }

    companion object {
        /**
         * Constant for minimal length of password
         * */
        private const val MIN_PASSWORD_LENGTH = 8
    }
}