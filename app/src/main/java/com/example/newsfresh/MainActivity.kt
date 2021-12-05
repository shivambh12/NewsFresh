package com.example.newsfresh

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest


class MainActivity : AppCompatActivity(), Newsitemclicked {
    private lateinit var madapter: NewsFreshAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView=findViewById(R.id.recycle)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val itemDecor = DividerItemDecoration(this, HORIZONTAL)
        recyclerView.addItemDecoration(itemDecor)
        val url=intent.getStringExtra("link")
        if (url != null) {
            fetchdata(url)
        }
        madapter = NewsFreshAdapter(this)
        recyclerView.adapter=madapter
        Log.d("Find", "Yes")
    }
    private fun fetchdata(url:String)
    {

        val jsonObjectRequest =object: JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                val newsjsonarray=response.getJSONArray("articles")
                val newsarray=ArrayList<News>()
                for(i in 0 until newsjsonarray.length())
                {
                    val jsonobject=newsjsonarray.getJSONObject(i)
                    val news=News(
                        jsonobject.getString("title"),
                        jsonobject.getString("author"),
                        jsonobject.getString("url"),
                        jsonobject.getString("urlToImage")
                    )
                    newsarray.add(news)
                }
                madapter.updatenews(newsarray)
            },
            Response.ErrorListener { error ->
                Log.d("error",error.localizedMessage)
            }
        )
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"]="Mozilla/5.0"
                return headers
            }
        }

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onitemclicked(item: News) {
        val customTabsIntent = CustomTabsIntent.Builder();
        customTabsIntent.setToolbarColor(Color.parseColor("#008000"))
        opencustomtab(this,customTabsIntent.build(),Uri.parse(item.url))

    }
    fun opencustomtab(activity: Activity, customTabsIntent: CustomTabsIntent,uri: Uri)
    {
        val packageName="com.android.chrome"
        if(packageName!=null)
        {
            customTabsIntent.intent.setPackage(packageName)
            customTabsIntent.launchUrl(activity,uri)
        }
        else
        {
            activity.startActivity(Intent(Intent.ACTION_VIEW,uri))
        }
    }

}