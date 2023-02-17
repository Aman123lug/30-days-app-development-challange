package com.example.day_12_show_information_in_display

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY = "com.example.day_12_show_information_in_display.KEY"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val message = name.text.toString() + " " + age.text.toString() + " " + weight.text.toString() + " " + blood_group.text.toString()
            intent = Intent(this, Order::class.java)
            intent.putExtra(KEY, message)

            startActivity(intent)
        }
    }
}

