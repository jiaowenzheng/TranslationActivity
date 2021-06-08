package com.translation.sample.behavior

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.translation.sample.R

/**
 * @program: TranslationActivity
 *
 * @description:
 *
 * @author: Mr.Wang
 *
 * @create: 2021-06-06 12:10
 **/
class ItemAdapter(private var data: List<String>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fling_behavior,null)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
       return data.size
    }

}

class CustomViewHolder(item: View) : RecyclerView.ViewHolder(item){

     var textView: TextView = item.findViewById(R.id.tv_text)

}