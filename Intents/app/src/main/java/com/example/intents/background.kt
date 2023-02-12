package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class background : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)


        val btnIntent2 = findViewById<Button>(R.id.screen2)
        btnIntent2.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
    }
}