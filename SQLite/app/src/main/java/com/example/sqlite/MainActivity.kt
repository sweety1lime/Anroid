package com.example.sqlite

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var peopleDB: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        peopleDB = DatabaseHelper(this@MainActivity)
        btnAdd.setOnClickListener { addUser() }
        btnShow.setOnClickListener { showUsers() }

        btnDelete.setOnClickListener { deleteUsers() }
        btnRefresh.setOnClickListener { updateUsers() }
    }

    private fun updateUsers() {
        peopleDB!!.update(edtName.text.toString(),edtEmail.text.toString(),ID.text.toString().toInt())
        Toast.makeText(this, "Данные обновлены", Toast.LENGTH_SHORT).show()
    }

    private fun deleteUsers() {
        val data = peopleDB!!.poisk(ID.text.toString().toInt())
        val buffer = StringBuffer()
        while(data!!.moveToNext())
        {
            buffer.append("ID: ${data.getString(0)} \n")
            buffer.append("Name: ${data.getString(1)} \n")
            buffer.append("Email: ${data.getString(2)} \n")
        }
        if(peopleDB!!.delete(ID.text.toString().toInt()) == true)
        {
            display("Удален пользователь", buffer.toString())
        }else
        {
            Toast.makeText(this, "Нет такого пользователя", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showUsers() {
        val data: Cursor? = peopleDB!!.showData()

        if (data!!.getCount() == 0) {
            display("Error", "нет данных")
            return
        }
        val buffer = StringBuffer()
        while(data.moveToNext())
        {
            buffer.append("ID: ${data.getString(0)} \n")
            buffer.append("Name: ${data.getString(1)} \n")
            buffer.append("Email: ${data.getString(2)} \n")
        }

        display("Все пользователи", buffer.toString())
    }
    private fun addUser() {
        val name: String = edtName.text.toString()
        val email: String = edtEmail.text.toString()

        val insertData: Boolean = peopleDB!!.addData(name, email)

        if (insertData == true) {
            Toast.makeText(this, "Запись добавлена", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Что-то пошло не так", Toast.LENGTH_SHORT).show()
        }
    }

    fun display(title: String, message: String) {
        val bulder: AlertDialog.Builder = AlertDialog.Builder(this)
        bulder.setCancelable(true)
        bulder.setTitle(title)
        bulder.setMessage(message)
        bulder.show()
    }
}


