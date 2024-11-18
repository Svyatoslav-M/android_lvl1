package com.example.homework_1.AuthActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.homework_1.MyProfileActivity.MainActivity
import com.example.homework_1.R

/**
 * Class for activity with authentication.
 */
class AuthActivity : AppCompatActivity() {

    private var editTextEmail : EditText? = null
    private var editTextPassword : EditText? = null
    private lateinit var buttonRegister : Button

    private var isAllFieldsCorrect = false

    private lateinit var fieldsChecker : FieldsChecker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        editTextEmail = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword)

        buttonRegister = findViewById(R.id.buttonRegister)

        fieldsChecker = FieldsChecker()

        buttonRegister.setOnClickListener {
            isAllFieldsCorrect = fieldsChecker.checkAllFields(editTextEmail, editTextPassword)

            if (isAllFieldsCorrect) {
                val intent = Intent(this@AuthActivity, MainActivity::class.java)
                intent.putExtra("email", editTextEmail!!.text.toString())
                startActivity(intent)
            }
        }
    }


}