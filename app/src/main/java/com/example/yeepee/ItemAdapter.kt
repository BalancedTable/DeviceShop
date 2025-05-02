package com.example.yeepee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var items:List<Item>, var context:Context): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    class MyViewHolder(view:View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.itemListImage)
        val title: TextView = view.findViewById(R.id.itemListTitle)
        val descrip: TextView = view.findViewById(R.id.itemListDescription)
        val price: TextView = view.findViewById(R.id.itemListPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.descrip.text = items[position].descr
        holder.price.text = items[position].price.toString() + "$"

        var imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)
    }
}