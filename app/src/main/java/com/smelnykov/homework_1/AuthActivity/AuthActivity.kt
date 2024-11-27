package com.smelnykov.homework_1.AuthActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.smelnykov.homework_1.Constants.Constants
import com.smelnykov.homework_1.MyProfileActivity.MyProfileActivity
import com.smelnykov.homework_1.databinding.ActivityAuthBinding

/**
 * Class for activity with authentication.
 */
class AuthActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
                sendEmail(editTextEmail.text.toString())
            }
        }
    }

    /**
     * Method for sending email to My Profile Activity.
     * @param email email which will be send
     * */
    private fun sendEmail(email: String) {
        val intent = Intent(this@AuthActivity, MyProfileActivity::class.java)
        intent.putExtra(Constants.EMAIL_AUTH_KEY, email)
        startActivity(intent)
    }

}