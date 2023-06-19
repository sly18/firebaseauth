package com.example.firebaseauth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase




class Registration : AppCompatActivity() {
    lateinit var gotologin:TextView
    lateinit var Edtregemail:EditText
    lateinit var Edtregpassword:EditText
    lateinit var Edtconfpass:EditText
    lateinit var Btn_register:Button
    lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        gotologin=findViewById(R.id.Tv_login)
        Edtregemail=findViewById(R.id.edtLoginemail)
        Edtregpassword=findViewById(R.id.edtPassword)
        Edtconfpass=findViewById(R.id.edtconPassword2)
        Btn_register=findViewById(R.id.btn_register)
        auth=Firebase.auth


        gotologin.setOnClickListener {
            val reg=Intent(this,MainActivity::class.java)
            startActivity(reg)
        }
        Btn_register.setOnClickListener {
            Signupuser()

        }

    }
    private fun  Signupuser(){
        val email:String=Edtregemail.text.toString()
        val pass:String=Edtregpassword.text.toString()
        val confpass:String=Edtconfpass.text.toString()

        if (email.isBlank()||pass.isBlank()||confpass.isBlank()){
            Toast.makeText(this,"signed up successfully",Toast.LENGTH_LONG).show()
            finish()

        }else{
            Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
        }
    }
}