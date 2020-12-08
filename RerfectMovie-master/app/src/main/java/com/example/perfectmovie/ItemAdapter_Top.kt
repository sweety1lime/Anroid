package com.example.perfectmovie

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.perfectmovie.Model.Json_results
import com.example.perfectmovie.Model.TopModel
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

const val URI_IMAGE: String = "https://image.tmdb.org/t/p/w500/"

class ItemAdapter_Top(
    private val context: Context,
    private val movie: ArrayList<Json_results>?,
    private val boolean: Boolean,
    private val listener: (Json_results) -> Unit
) : RecyclerView.Adapter<ItemAdapter_Top.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rating = view.findViewById<TextView>(R.id.vote_average)
        val poster = view.findViewById<ImageView>(R.id.poster)
        var title = view.findViewById<TextView>(R.id.title)
        var progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        var release_date = view.findViewById<TextView>(R.id.release_date)
        fun View(
            date: Json_results,
            context: Context,
            boolean: Boolean,
            listener: (Json_results) -> Unit
        ) {
            rating.text = date.vote_average
            title.text = date.title
            if (boolean) {
                release_date.text = "Дата выхода фильма: ${date.release_date}"
                release_date.visibility = VISIBLE
            }

            Picasso.with(context)
                .load(URI_IMAGE + date.poster_path)
                .into(poster, object : Callback {
                    override fun onSuccess() {
                        if (progressBar != null) {
                            progressBar.visibility = View.GONE
                        }
                    }

                    override fun onError() {
                        TODO("Not yet implemented")
                    }
                })

            itemView.setOnClickListener { listener(date) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_item_list, parent, false)
        )

    override fun getItemCount(): Int = movie!!.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.View(movie!![position], this.context,this.boolean,listener)
    }

}