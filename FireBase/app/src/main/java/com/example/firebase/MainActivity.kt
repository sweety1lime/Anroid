package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        var btn_signup = findViewById<Button>(R.id.btn_signup)
        var btn_login = findViewById<Button>(R.id.btn_login)

        btn_signup.setOnClickListener {
            signUpUsers()
        }

        btn_login.setOnClickListener {
            signInUsers()
        }
    }

    private fun signInUsers() {
        auth.signInWithEmailAndPassword(edt_login.text.toString(),edt_password.text.toString()).addOnCompleteListener (this){ task ->
            if (task.isSuccessful){
                Toast.makeText(this, "Пользователь авторизован", Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(this, "ошибка", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun signUpUsers() {
        auth.createUserWithEmailAndPassword(edt_login.text.toString(),edt_password.text.toString()).addOnCompleteListener (this){ task ->
            if (task.isSuccessful){
                Toast.makeText(this, "Пользователь заргистрирован", Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()

            }
        }
    }
}