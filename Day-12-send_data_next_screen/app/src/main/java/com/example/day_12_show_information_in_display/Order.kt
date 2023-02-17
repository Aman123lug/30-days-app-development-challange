package com.example.day_12_show_information_in_display


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order.*

class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val ordersOfCustomer= intent.getStringExtra(MainActivity.KEY)


        show.text = "Order Placed " + ordersOfCustomer.toString()
    }
}