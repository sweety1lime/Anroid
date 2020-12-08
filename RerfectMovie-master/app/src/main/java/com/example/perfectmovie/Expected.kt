package com.example.perfectmovie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.perfectmovie.Model.ExpectedModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Expected : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendNetvorkReauest()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_expected, container, false)
    }

    fun sendNetvorkReauest()
    {
        val builder = Retrofit.Builder().baseUrl(URI).addConverterFactory(GsonConverterFactory.create())
        val retrofit= builder.build()
        val interfase = retrofit.create<Interface_API>(Interface_API::class.java)

        val call: retrofit2.Call<ExpectedModel> = interfase.getExpected_Movie()

        call.enqueue(object : retrofit2.Callback<ExpectedModel>
        {
            override fun onFailure(call: Call<ExpectedModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ExpectedModel>, response: Response<ExpectedModel>) {
                var array = response.body()!!.result
                activity?.runOnUiThread () {
                    val recycler = activity?.findViewById<RecyclerView>(R.id.imageRecyclerView)
                    recycler?.layoutManager = LinearLayoutManager(activity)
                    recycler?.setHasFixedSize(true)
                    val adapter = ItemAdapter_Top(activity!!.applicationContext,array,true)
                    {
                        var intent: Intent = Intent(activity!!.applicationContext, ItemMovie::class.java)
                        intent.putExtra("OBJECK", it)
                        startActivity(intent)
                        Animatoo.animateSpin(context)
                    }
                    recycler?.adapter = adapter
                }
            }
        })

    }
}