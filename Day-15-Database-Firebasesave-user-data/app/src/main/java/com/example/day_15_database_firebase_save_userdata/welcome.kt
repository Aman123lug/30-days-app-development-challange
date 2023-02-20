package com.example.day_15_database_firebase_save_userdata


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnemail = findViewById<Button>(R.id.showemail)
        val btnumber = findViewById<Button>(R.id.shownumber)

    }
}