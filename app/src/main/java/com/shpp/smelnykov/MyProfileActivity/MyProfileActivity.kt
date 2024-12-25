package com.shpp.smelnykov.MyProfileActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shpp.smelnykov.AuthActivity.AuthActivity
import com.shpp.smelnykov.AuthPreferences.AuthPreferences
import com.shpp.smelnykov.MyContacts.MyContactsActivity
import com.shpp.smelnykov.databinding.ActivityMyProfileBinding

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
            AuthPreferences.clearData(this)
            logOutRedirection()
        }
        binding.appCompatImageViewContacts.setOnClickListener {
            viewMyContacts()
        }
    }

    /**
     * Method for changing activity to Authorization activity.
     * */
    private fun logOutRedirection() {
        val intent = Intent(this@MyProfileActivity, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun viewMyContacts() {
        val intent = Intent(this@MyProfileActivity, MyContactsActivity::class.java)
        startActivity(intent)
    }
}