package com.translation.shopcartanimation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GuideAdapter(private val data: List<String>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_guide,parent,false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.item.text = data[position]

        holder.item.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getData() = data
}
