 package com.example.firebase.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.firebase.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

 class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etname=findViewById<EditText>(R.id.etname)
        var etemail=findViewById<EditText>(R.id.etmail)
        var etpassword=findViewById<EditText>(R.id.password)
        var etuniqueid=findViewById<EditText>(R.id.uniqueId)
        var login=findViewById<Button>(R.id.login)

        login.setOnClickListener {
            var name= etname.text.toString()
            var email=etemail.text.toString()
            var password=etpassword.text.toString()
            var uniqueid=etuniqueid.text.toString()

            var user= User(name,email, password, uniqueid)
            database = FirebaseDatabase.getInstance().getReference("User")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"User notRegistered",Toast.LENGTH_SHORT).show()
            }
        }
    }
}