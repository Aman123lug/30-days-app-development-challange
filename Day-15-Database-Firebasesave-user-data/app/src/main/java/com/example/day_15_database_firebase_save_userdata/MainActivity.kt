package com.example.day_15_database_firebase_save_userdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val name = findViewById<TextInputEditText>(R.id.name)
        val number = findViewById<TextInputEditText>(R.id.number)
        val mail = findViewById<TextInputEditText>(R.id.mail)
        val passwords = findViewById<TextInputEditText>(R.id.password)
        val btnsignup = findViewById<Button>(R.id.signup)

        btnsignup.setOnClickListener{
            val nametext = name.text.toString()
            val numtext = number.text.toString()
            val uniqueId = mail.text.toString()
            val passtext = passwords.text.toString()

            val user = User(nametext, numtext, uniqueId, passtext)


            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {

                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()

            }.addOnSuccessListener {
                Toast.makeText(this, "Something went wrong !", Toast.LENGTH_SHORT).show()


            }



        }
    }
}