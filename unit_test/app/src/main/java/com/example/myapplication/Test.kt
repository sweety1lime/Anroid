package com.example.myapplication

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class Test_Unit {
    fun summ(a:Int, b:Int): Int{
        return a + b
    }


    val okHttpClient: OkHttpClient = OkHttpClient()
    fun API(URL: String): String {
        var test: String = ""
        val request: Request = Request.Builder().url(URL).build()
        var response = okHttpClient.newCall(request).execute()
        var joke1 = ((JSONObject(response!!.body()!!.string())).getJSONArray("articles").getJSONObject(0).getString("publishedAt")).toString()
        return joke1;
    }
}