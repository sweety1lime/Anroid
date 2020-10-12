package com.example.retrofit.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {

    @SerializedName("title")
    @Expose
    private var title: String = ""

    @SerializedName("body")
    @Expose
    private var body: String? = null

    @SerializedName("userId")
    @Expose
    private var userId: Int? = null

    @SerializedName("id")
    @Expose
    private var id: Int? = null


    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String?) {
        this.body = body
    }

    fun getUserId(): Int? {
        return userId
    }

    fun setUserId(userId: Int?) {
        this.userId = userId
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }


    override fun  toString(): String {
       return "Post{" +
           "title=’" + title + "/" +
            ", body=’" + body + "/" +
            ", userId=" + userId +
            ", id=»" + id +
            "}"
   }

}