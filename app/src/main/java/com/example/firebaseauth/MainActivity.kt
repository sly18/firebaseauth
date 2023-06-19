package com.example.firebaseauth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoregister: TextView
    lateinit var Edtlogemail: EditText
    lateinit var Edtlogpass: EditText
    lateinit var Btn_login: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoregister = findViewById(R.id.tv_register)
        Edtlogemail = findViewById(R.id.edtEmailAddress)
        Edtlogpass = findViewById(R.id.edtPass)
        Btn_login = findViewById(R.id.but_login)
        auth = FirebaseAuth.getInstance()

        Txt_gotoregister.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        Btn_login.setOnClickListener {
            login()
        }
    }
  private fun login(){
      val email=Edtlogemail.text.toString()
      val password=Edtlogpass.text.toString()
      auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
          if (it.isSuccessful){
              Toast.makeText(this,"successfully logged in",Toast.LENGTH_LONG).show()
          }else{
              Toast.makeText(this,"LOg in failed",Toast.LENGTH_LONG).show()
          }
      }
  }

}