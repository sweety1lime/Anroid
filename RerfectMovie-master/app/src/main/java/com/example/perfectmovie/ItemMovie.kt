package com.example.perfectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.perfectmovie.Model.Json_results
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_movie.*

class ItemMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_movie)

        var item = intent.getParcelableExtra<Json_results>("OBJECK")
        Title.text = item?.title
        vote_average.text = item?.vote_average
        release_date.text = "Дата релиза фильма: ${item?.release_date}"
        var isclick: Boolean = true
        description.setOnClickListener {
            val anim : Animation
            if (isclick) {
                description_text.text = item?.overview
                description_text.visibility = View.VISIBLE
                isclick = false
                anim = AnimationUtils.loadAnimation(this,R.anim.myalpha)

            }
            else{
                anim = AnimationUtils.loadAnimation(this,R.anim.mybeta)
                description_text.visibility = View.INVISIBLE
                isclick = true
            }
            description_text.startAnimation(anim)
        }
        Picasso.with(this)
            .load(URI_IMAGE + item?.poster_path)
            .into(image_poster, object : Callback {
                override fun onSuccess() {
                    if (progressBar != null) {
                        progressBar.visibility = View.GONE
                    }
                }

                override fun onError() {
                    Log.i("this", "")
                }
            })

    }
}