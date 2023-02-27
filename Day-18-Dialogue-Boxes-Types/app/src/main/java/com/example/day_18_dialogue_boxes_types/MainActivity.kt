package com.example.day_18_dialogue_boxes_types

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.day_18_dialogue_boxes_types.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btn1.setOnClickListener{
            val buider1 = AlertDialog.Builder(this)

            buider1.setTitle("Are you Sure!")
            buider1.setMessage("Do You Want to Close Your App!")
            buider1.setIcon(R.drawable.ic_android_black_24dp)
            buider1.setPositiveButton("Yes", DialogInterface.OnClickListener{dialogInterface, i ->
                // action is performed by when Yes is Clicked !

                finish()
            })
            buider1.setNegativeButton("No", DialogInterface.OnClickListener{dialogInterface, i ->
                // action is performed by when No is Clicked !
            })
            buider1.show()
        }

        // button 2
        binding.btn2.setOnClickListener {
            val options = arrayOf("aman", "dev", "khusi", "shreya",)
            val builder2 = AlertDialog.Builder(this)


            builder2.setTitle("which one is your fav ?")
            builder2.setIcon(R.drawable.ic_android_black_24dp)
            builder2.setSingleChoiceItems(
                options,
                0,
                DialogInterface.OnClickListener { dialogInterface, i, ->
                    // action
                    Toast.makeText(this, "you clicked ${options[i]}", Toast.LENGTH_SHORT).show()

                })
            builder2.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->

                })
            builder2.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder2.show()


        }






    }
}