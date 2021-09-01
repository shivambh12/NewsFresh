package com.example.newsfresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun bussinessurl(view: View) {
        val url:String="https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=7fbca123f8e84b36b46a1c2061c9adef"
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("link",url)
        startActivity(intent)
    }
    fun entertainmenturl(view: View) {
        val url:String="https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=7fbca123f8e84b36b46a1c2061c9adef"
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("link",url)
        startActivity(intent)
    }
    fun sportsurl(view: View) {
        val url:String="https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=7fbca123f8e84b36b46a1c2061c9adef"
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("link",url)
        startActivity(intent)
    }
    fun technologyurl(view: View) {
        val url:String="https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=7fbca123f8e84b36b46a1c2061c9adef"
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("link",url)
        startActivity(intent)
    }
    fun generalurl(view: View) {
        val url:String="https://newsapi.org/v2/top-headlines?country=in&category=general&apiKey=7fbca123f8e84b36b46a1c2061c9adef"
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("link",url)
        startActivity(intent)
    }
    fun healthurl(view: View) {
        val url:String="https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=7fbca123f8e84b36b46a1c2061c9adef"
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("link",url)
        startActivity(intent)
    }
}