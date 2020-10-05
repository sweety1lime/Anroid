package com.example.ui_test

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_win2.*

class win2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win2)
        val arguments = intent.extras

        textView.text = arguments?.get("XANDO").toString()

    }

    fun Exit(view: View) {

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent);
    }
}