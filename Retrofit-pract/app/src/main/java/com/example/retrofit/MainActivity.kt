package com.example.retrofit

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.Model.Example
import com.example.retrofit.Model.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendNetworkRequest()
        post()
    }


    fun post() {
        val buld = Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = buld.build()
        var interf = retrofit.create<Interface>(Interface::class.java)
        val call: retrofit2.Call<Example> = interf.getPost("one", "two", 228)
        call.enqueue(object : retrofit2.Callback<Example> {
            override fun onFailure(call: Call<Example>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                showResponse(response.body().toString())
                Log.i("TAG", "post submitted to API." + response.body().toString());
            }
        })
    }

    private fun showResponse(toString: String) {
        test.text = toString

    }


    fun sendNetworkRequest() {
        val builder = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
        var retrofit = builder.build()
        var interf = retrofit.create<Interface>(Interface::class.java)
        val call: retrofit2.Call<ViewModel> = interf.getFile()
        call.enqueue(object : retrofit2.Callback<ViewModel> {
            override fun onFailure(call: retrofit2.Call<ViewModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: retrofit2.Call<ViewModel>,
                response: Response<ViewModel>
            ) {
                Log.i("Test", response.body()!!.file!!.get(0).file!!)
                news.text = response.body()!!.file!!.get(0).file!!
            }

        })
    }
}
