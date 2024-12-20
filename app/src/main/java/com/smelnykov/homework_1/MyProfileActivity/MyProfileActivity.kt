package com.smelnykov.homework_1.MyProfileActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smelnykov.homework_1.AuthActivity.AuthActivity
import com.smelnykov.homework_1.AuthPreferences.AuthPreferences
import com.smelnykov.homework_1.databinding.ActivityMyProfileBinding

/**
 * Class for my profile activity.
 */
class MyProfileActivity : AppCompatActivity() {

    private val binding: ActivityMyProfileBinding by lazy {
        ActivityMyProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        val email = AuthPreferences.getUserEmail(this)
        if (email != null) {
            setNameFromEmail(email)
        }

        setClickListeners()
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

    /**
     * Method sets up the click listeners for log out button.
     */
    private fun setClickListeners() {

        binding.appCompatButtonLogOut.setOnClickListener {
            clearData()
            logOutRedirection()
        }
    }

    /**
     * Method clears users data in sharedPreference.
     * */
    private fun clearData() {
        AuthPreferences.clearData(this)
    }

    /**
     * Method for changing activity to Authorization activity.
     * */
    private fun logOutRedirection() {
        val intent = Intent(this@MyProfileActivity, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}