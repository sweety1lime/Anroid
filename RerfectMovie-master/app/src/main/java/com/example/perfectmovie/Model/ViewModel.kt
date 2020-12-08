package com.example.perfectmovie.Model

import android.icu.text.CaseMap
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class TopModel() : Parcelable {
    @SerializedName("results")
    @Expose
    var result: ArrayList<Json_results>? = null
}

@Parcelize
data class Json_results(
    @SerializedName("vote_average")
    @Expose
    val vote_average: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("release_date")
    @Expose
    val release_date: String,

    @SerializedName("poster_path")
    @Expose
    val poster_path: String,

    @SerializedName("overview")
    @Expose
    val overview: String
) : Parcelable {


}

@Parcelize
class ExpectedModel() : Parcelable {
    @SerializedName("results")
    @Expose
    var result: ArrayList<Json_results>? = null
}

