package com.himanshu.newsfresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsFreshAdapter( private val  listner: NewsClick): RecyclerView.Adapter<NewsViewHolder>()
{    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
 {
  val view = LayoutInflater.from(parent.context).inflate(R.layout.items_view,parent,false)
     val viewHolder =  NewsViewHolder(view)
     view.setOnClickListener()
     {
       listner.onItemClicked(items[viewHolder.adapterPosition])
     }
  return viewHolder
 }
    override fun getItemCount(): Int
    {
        return items.size
    }
 override fun onBindViewHolder(holder: NewsViewHolder, position: Int)
 {
     
   val currentItem = items[position]
   holder.titleView.text = currentItem.title
     holder.authorView.text = currentItem.author
     Glide.with(holder.imageView.context).load(currentItem.imageUrl).into(holder.imageView)
 }
    fun updateNews(updatedNews: ArrayList<News>)
    {
        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()
    }
}
class  NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
    val authorView: TextView = itemView.findViewById(R.id.author)
    val imageView: ImageView = itemView.findViewById(R.id.image)
 }
interface NewsClick{
    fun onItemClicked(item: News)

}