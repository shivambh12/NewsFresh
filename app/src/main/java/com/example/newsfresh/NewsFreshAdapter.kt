package com.example.newsfresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsFreshAdapter(private val listner:Newsitemclicked): RecyclerView.Adapter<NewsViewHolder>()
{
    private val items:ArrayList<News> =ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.itemnews,parent,false)
        val viewholder=NewsViewHolder(view)
        view.setOnClickListener{
            listner.onitemclicked(items[viewholder.adapterPosition])
        }
        return viewholder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val curentirem=items[position]
        holder.titleview.text=curentirem.title
        holder.author.text=curentirem.author
        Glide.with(holder.itemView.context).load(curentirem.imageUrl).into(holder.imageview)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updatenews(updateitems :ArrayList<News>)
    {
        items.clear()
        items.addAll(updateitems)
        notifyDataSetChanged()
    }

}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val titleview: TextView=itemView.findViewById(R.id.title)
      val imageview: ImageView=itemView.findViewById(R.id.imageview)
    val author:TextView=itemView.findViewById(R.id.author)
}
interface Newsitemclicked
{
    fun onitemclicked(item: News)
}
