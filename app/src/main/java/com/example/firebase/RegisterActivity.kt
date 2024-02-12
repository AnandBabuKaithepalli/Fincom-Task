package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.firebase.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

   private lateinit var binding:ActivityRegisterBinding
   private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.tvRegister.setOnClickListener {

            val email=binding.tvEmail.toString()
            val password=binding.tvPassword.toString()
            if(email.isEmpty()){
                binding.tvEmail.error="Enter Email"
                binding.tvEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                binding.tvPassword.error="Enter Email"
                binding.tvPassword.requestFocus()
                return@setOnClickListener
            }
            if(password.length<6){
                binding.tvPassword.error="Password must have above six chars"
                binding.tvPassword.requestFocus()
                return@setOnClickListener
            }
            registerFirebase(email,password)
        }
    }

    private fun registerFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this,"Registration successful",Toast.LENGTH_SHORT).show()
                    val intent =Intent(this,Welcome::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Registration unsuccessful",Toast.LENGTH_SHORT).show()
                }
            }

    }
}