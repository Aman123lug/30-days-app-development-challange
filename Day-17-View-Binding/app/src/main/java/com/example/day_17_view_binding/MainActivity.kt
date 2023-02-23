package com.example.day_17_view_binding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.day_17_view_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var Binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        Binding.button.setOnClickListener{
            if(Binding.checkBox.isChecked){
                intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Please accept the policy !", Toast.LENGTH_SHORT).show()
            }
        }


        supportActionBar?.hide()

    }
}