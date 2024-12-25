package com.shpp.smelnykov.AuthActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shpp.smelnykov.AuthPreferences.AuthPreferences
import com.shpp.smelnykov.MyProfileActivity.MyProfileActivity
import com.shpp.smelnykov.databinding.ActivityAuthBinding

/**
 * Class for activity with authentication.
 */
class AuthActivity : AppCompatActivity() {

    private val binding: ActivityAuthBinding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        if (AuthPreferences.isUserLoggedIn(this)) {
            autoLogin()
        }

        setClickListeners()
    }

    /**
     * Method sets up the click listeners for the register button.
     * Checks if the entered email and password are valid,
     * and shows appropriate error messages if they are not.
     */
    private fun setClickListeners() {
        val editTextEmail = binding.editTextTextEmailAddress
        val editTextPassword = binding.editTextTextPassword

        val buttonRegister = binding.buttonRegister

        val emailError = binding.textEmailError
        val passwordError = binding.textPasswordError

        val fieldsChecker = FieldsChecker()

        buttonRegister.setOnClickListener {
            var isAllFieldsCorrect = true

            if (!fieldsChecker.checkEmail(editTextEmail.text.toString())) {
                emailError.visibility = View.VISIBLE
                isAllFieldsCorrect = false
            } else {
                emailError.visibility = View.GONE
            }
            if (!fieldsChecker.checkPassword(editTextPassword.text.toString())) {
                passwordError.visibility = View.VISIBLE
                isAllFieldsCorrect = false
            } else {
                passwordError.visibility = View.GONE
            }

            if (isAllFieldsCorrect) {
                registerAndChangeActivity(
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString()
                )
            }
        }
    }

    /**
     * Method for saving email, password and change activity to My Profile Activity.
     * @param email email which will be saved
     * @param password password which will be saved
     * */
    private fun registerAndChangeActivity(email: String, password: String) {
        // Save user credentials
        AuthPreferences.saveCredentials(this, email, password)

        // Start the new activity
        navigateToProfile()
    }

    private fun navigateToProfile() {
        val intent = Intent(this, MyProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * Method for autologin redirection to my profile activity.
     * */
    private fun autoLogin() {
        val intent = Intent(this@AuthActivity, MyProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

}