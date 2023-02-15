package com.example.web_view_fully_functional_app_3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second_page.*

class SecondPage : AppCompatActivity() {


}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)


        book.setOnClickListener{
            val str = order1.text.toString() + " " + order2.text.toString() + " " + order3.text.toString() + " " + order4.text

            intent = Intent(this, Order::java)
            startActivity(intent)
        }

//





