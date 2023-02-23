package com.example.day_15_database_firebase_save_userdata


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class welcome : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        // buttons

        // getting information of user
        val email = intent.getStringExtra(SignInActivity.KEY1)
        val name = intent.getStringExtra(SignInActivity.KEY2)
        val number = intent.getStringExtra(SignInActivity.KEY3)

        // creating variables for this
        val showename = findViewById<TextView>(R.id.showename)



        showename.text = "Welcome $name"






    }
}