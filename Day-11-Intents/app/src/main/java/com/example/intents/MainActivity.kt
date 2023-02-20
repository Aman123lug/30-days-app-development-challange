package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnIntent = findViewById<Button>(R.id.screen1)
        btnIntent.setOnClickListener{
            // open new activity
            intent = Intent(applicationContext, background::class.java)
            startActivity(intent)

        }




    }
}