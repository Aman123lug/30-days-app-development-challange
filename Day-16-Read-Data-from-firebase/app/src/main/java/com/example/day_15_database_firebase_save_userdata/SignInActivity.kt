package com.example.day_15_database_firebase_save_userdata


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    companion object {

        const val KEY1 = "com.example.day_15_database_firebase_save_userdata.SignInActivity.email"
        const val KEY2 = "com.example.day_15_database_firebase_save_userdata.SignInActivity.name"
        const val KEY3 = "com.example.day_15_database_firebase_save_userdata.SignInActivity.number"

    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        supportActionBar?.hide()

        // Sign-up button
        val signPageSignInbtn = findViewById<TextView>(R.id.signinbtn)
        signPageSignInbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnusername = findViewById<TextInputEditText>(R.id.username)



        val btnsign = findViewById<Button>(R.id.signin)

        btnsign.setOnClickListener{

            // created string
            val useruniqueId = btnusername.text.toString()



            if (useruniqueId.isNotEmpty()){

                readData(useruniqueId).toString()


            }else{
                Toast.makeText(this, "please enter username !", Toast.LENGTH_SHORT).show()
            }


        }


    }

    private fun readData(uniqueId: String) {


        databaseReference = FirebaseDatabase.getInstance().getReference("User")

        databaseReference.child(uniqueId).get().addOnSuccessListener {
            Toast.makeText(this, "Wait Signin..", Toast.LENGTH_SHORT).show()

            if(it.exists()) {
                // Welcome user !
                val email = it.child("email").value.toString()
                val name = it.child("name").value.toString()
                val number = it.child("number").value.toString()

                val intent = Intent(this, welcome::class.java)

                intent.putExtra(KEY1, email)
                intent.putExtra(KEY2, name)
                intent.putExtra(KEY3, number)
                startActivity(intent)

            }else{
                Toast.makeText(this, "User Name Incorrect !", Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener{
            Toast.makeText(this, "you are not registered sign-up first !", Toast.LENGTH_SHORT).show()
        }





    }


}