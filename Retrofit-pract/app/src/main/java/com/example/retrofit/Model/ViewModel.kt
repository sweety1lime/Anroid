package com.example.retrofit.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ViewModel
{
//    @SerializedName("articles")
//    @Expose
//    var file:String? = null

    @SerializedName("articles")
    @Expose
    var file: Array<Articles>? = null

}
class Articles
{
    @SerializedName("title")
    @Expose
    var file:String? = null
}

