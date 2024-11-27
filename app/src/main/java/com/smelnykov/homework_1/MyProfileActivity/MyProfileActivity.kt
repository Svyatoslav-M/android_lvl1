package com.smelnykov.homework_1.MyProfileActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smelnykov.homework_1.Constants.Constants
import com.smelnykov.homework_1.databinding.ActivityMyProfileBinding

/**
 * Class for my profile activity.
 */
class MyProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val email = intent.getStringExtra(Constants.EMAIL_AUTH_KEY)
        if (email != null) {
            setNameFromEmail(email)
        }
    }

    /**
     * Method for setup name from email at My Profile Activity.
     * @param email email which will be parse to name and surname
     * */
    private fun setNameFromEmail(email: String) {
        val parser = NameParser()
        val name = binding.appCompatTextName
        name.text = parser.parseNameSurname(email)
    }
}