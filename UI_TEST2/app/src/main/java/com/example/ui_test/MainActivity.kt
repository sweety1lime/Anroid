package com.example.ui_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var xando = "O"
    var bttext = Array(9) { "" }
    var btbool = BooleanArray(9) { true }

    fun count(vararg button: Button) {

        var intent = Intent(this, win2::class.java)

        if (xando == "X") {
            intent.putExtra("XANDO", xando)
        } else
            if (xando == "O") {
                intent.putExtra("XANDO", xando)
            }



        var i = 0
        while (i < 9) {
            bttext[i] = ""
            btbool[i] = true
            i++
        }
        startActivity(intent)
    }

    fun Enablefalse(vararg button: Button) {
        var i = 0
        if (button[8].text != "" && button[7].text != "" && button[6].text != "" && button[5].text != "" && button[4].text != "" && button[3].text != "" && button[2].text != "" && button[1].text != "" && button[0].text != "") {
            var intent = Intent(this, win2::class.java)
            intent.putExtra("XANDO", xando)
            startActivity(intent)
        } else {
            if (!pusk.isEnabled) count(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)

        }
        while (i < 9) {
            button[i].isEnabled = false
            button[i].text = null
            i++
        }
        pusk.isEnabled = true
    }

    //82 41
    fun Enabletrue(vararg button: Button) {
        var i = 0
        while (i < 9) {
            button[i].isEnabled = true
            i++
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)

    }

    fun Start(view: View) {
        Enabletrue(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        pusk.isEnabled = false

        xando = "O"
    }

    fun Game(view: View) {
        val button: Button = findViewById(view.id)
        if (xando == "X") {

            xando = "O"

        } else {
            xando = "X"
        }
        button.text = xando
        button.isEnabled = false
        vin(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
    }

    fun vin(vararg button: Button) {

        var i = 0
        while (i < 9) {
            bttext[i] = button[i].text.toString()
            btbool[i] = button[i].isEnabled
            i++
        }

        if (button[8].text != "" && button[7].text != "" && button[6].text != "" && button[5].text != "" && button[4].text != "" && button[3].text != "" && button[2].text != "" && button[1].text != "" && button[0].text != "") {
            xando = "ничья"
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }
        /**
         * варинат победы по горизонтали
         */
        if (button[0].text == xando && button[1].text == xando && button[2].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }
        if (button[3].text == xando && button[4].text == xando && button[5].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }
        if (button[6].text == xando && button[7].text == xando && button[8].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }

        /**
         * вариант победы по веритакали
         */
        if (button[0].text == xando && button[3].text == xando && button[6].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }
        if (button[1].text == xando && button[4].text == xando && button[7].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)

        }
        if (button[2].text == xando && button[5].text == xando && button[8].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }

        /**
         * вариант выиграша по диагонали
         */
        if (button[0].text == xando && button[4].text == xando && button[8].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }
        if (button[2].text == xando && button[4].text == xando && button[6].text == xando) {
            Enablefalse(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9)
        }
    }

}