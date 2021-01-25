package com.example.mvvm



import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvm.models.User
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(private val listener: LoginResultCallBacks) :ViewModel() {

    private val user: User
    private lateinit var auth: FirebaseAuth

    init {
        this.user = User("", "");
    }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                user.setEmail(p0.toString())
            }
        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                user.setPassword(p0.toString())
            }
        }
    fun onLoginClicked(v: View) {
        var main = MainActivity()
        if (user.isDataValid) {
            auth = FirebaseAuth.getInstance()
            auth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(main) { task ->
                    if (task.isSuccessful) {
                        listener.onSuccess("Пользователь заргистрирован")
                    } else {
                        listener.onError(task.exception!!.message.toString())
                    }
                }// Добавление данных в базу данных firebase
        } else {
            listener.onError("Ошибка")
        }
    }



}