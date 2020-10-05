package com.example.newsapi

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {
    // Россия США и Китай
    var URL: Array<String> = arrayOf(
        "http://newsapi.org/v2/top-headlines?country=us&apiKey=c22cef390cbf4ccb856d8e359c4cc21d",
        "http://newsapi.org/v2/top-headlines?country=cn&apiKey=c22cef390cbf4ccb856d8e359c4cc21d",
        "http://newsapi.org/v2/top-headlines?country=ru&apiKey=c22cef390cbf4ccb856d8e359c4cc21d"
    )

    var count = -1


    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putCharSequenceArrayList("Array", array as java.util.ArrayList<CharSequence>?)
            putInt("Key", count)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt("Key")
        array = savedInstanceState.getCharSequenceArrayList("Array") as ArrayList<ItemOfList>
        Adapter()
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View?,
                selectedItemPosition: Int,
                selectedId: Long
            ) {
                if (count != selectedItemPosition) {
                    count = selectedItemPosition
                    News(URL[selectedItemPosition])
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.example_menu, menu)
        var searchItem = menu!!.findItem(R.id.search)
        var search = searchItem.actionView as SearchView

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                News(URL[count] + "&q=" + p0)
                return false
            }
        })
        return true
    }

    var array: ArrayList<ItemOfList> = ArrayList()
    var save_URL = ""

    fun News(url: String) {
        val client: OkHttpClient = OkHttpClient()
        save_URL = url
        val request = Request.Builder().url(url).build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                var joson = JSONObject(response.body()!!.string()).getJSONArray("articles")
                var i = 0

                array.clear()
                while (joson.length() > i) {
                    var item = ItemOfList(
                        joson.getJSONObject(i).getString("title"),
                        joson.getJSONObject(i).getString("description"),
                        joson.getJSONObject(i).getJSONObject("source").get("name").toString(),
                        joson.getJSONObject(i).getString("publishedAt"),
                        joson.getJSONObject(i).getString("urlToImage")
                    )
                    array.add(item)
                    i++
                }
                runOnUiThread() {
                    Adapter()
                }
            }
        })
    }

    fun Adapter()
    {

        val recycler = findViewById<RecyclerView>(R.id.imageRecyclerView)
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler.setHasFixedSize(true)
        val adapter: ItemAdapter = ItemAdapter(this@MainActivity, array)
        {
            var intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("OBJECK", it)
            startActivity(intent)
        }
        recycler.adapter = adapter
    }
}
