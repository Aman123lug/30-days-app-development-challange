package com.example.day_15_database_firebase_save_userdata


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)



        val btnusername = findViewById<TextInputEditText>(R.id.username)
        val btnpass = findViewById<TextInputEditText>(R.id.pass)

        val btnsign = findViewById<Button>(R.id.signin)

        btnsign.setOnClickListener{

            // created string of both
            val useruniqueId = btnusername.text.toString()
            val userpasssword = btnpass.text.toString()


            if (useruniqueId.isNotEmpty()){

                val userdata = readData(useruniqueId, userpasssword).toString()
                intent = Intent(this, welcome::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "please enter username !", Toast.LENGTH_SHORT).show()
            }

            if (userpasssword.isNotEmpty()){

                val userdata = readData(useruniqueId, userpasssword).toString()
                intent = Intent(this, welcome::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "please enter password !", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun readData(uniqueId: String, passtext: String) {


        databaseReference = FirebaseDatabase.getInstance().getReference("User")

        databaseReference.child(uniqueId).get().addOnSuccessListener {
            Toast.makeText(this, "Wait Signin..", Toast.LENGTH_SHORT).show()

            if(it.exists()) {
                // Welcome user !
                val email = it.child("email").value
                val name = it.child("name").value
                val number = it.child("number").value

                val intent = Intent(this, welcome::class.java)
                startActivity(intent)
                intent.putExtra()


            }else{
                Toast.makeText(this, "User Name Incorrect !", Toast.LENGTH_SHORT).show()

            }


        }.addOnFailureListener{
            Toast.makeText(this, "you are not registered sign-up first !", Toast.LENGTH_SHORT).show()
        }




        databaseReference.child(passtext).get().addOnSuccessListener {
            Toast.makeText(this, "Wait Signin..", Toast.LENGTH_SHORT).show()

            if(it.exists()) {
                // Welcome user !
                val email = it.child("email").value
                val name = it.child("name").value
                val number = it.child("number").value
                val intent = Intent(this, welcome::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Password Incorrect !", Toast.LENGTH_SHORT).show()

            }
        }.addOnFailureListener{
            Toast.makeText(this, "you are not registered sign-up first !", Toast.LENGTH_SHORT).show()
        }



    }
}