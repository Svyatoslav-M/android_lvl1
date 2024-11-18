package com.example.homework_1.MyProfileActivity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_1.R

/**
 * Class for my profile activity.
 */
class MainActivity : AppCompatActivity() {

    var name: TextView? = null
    private lateinit var parser: NameParser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        parser = NameParser()

        val email = intent.getStringExtra("email")

        name = findViewById(R.id.nameTextView)
        name!!.text = parser.parseNameSurname(email!!)
    }
}