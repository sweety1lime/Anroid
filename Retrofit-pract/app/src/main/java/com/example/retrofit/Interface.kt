package com.example.retrofit

import com.example.retrofit.Model.Example
import com.example.retrofit.Model.ViewModel
import retrofit2.Call
import retrofit2.http.*

interface Interface {

    @GET("everything?q=game&from=2020-09-12&sortBy=publishedAt&apiKey=c22cef390cbf4ccb856d8e359c4cc21d")
    fun getFile(): Call<ViewModel>

    @POST("/posts")
    @FormUrlEncoded
    fun getPost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Int
    ): Call<Example>
}