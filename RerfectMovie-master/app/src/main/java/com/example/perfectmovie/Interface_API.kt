package com.example.perfectmovie

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.perfectmovie.Model.ExpectedModel
import com.example.perfectmovie.Model.Json_results
import com.example.perfectmovie.Model.TopModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Interface_API {
    @GET("top_rated?&api_key=${BuildConfig.API_KEY}")
    fun getTop_Movie(): Call<TopModel>

    @GET("upcoming?&api_key=${BuildConfig.API_KEY}")
    fun getExpected_Movie(): Call<ExpectedModel>

}