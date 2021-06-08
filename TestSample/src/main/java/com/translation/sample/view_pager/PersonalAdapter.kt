package com.translation.sample.view_pager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.translation.sample.R

class PersonalAdapter(private val data: ArrayList<String>?) : RecyclerView.Adapter<PersonalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalViewHolder {
        return PersonalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_personal,null))
    }

    override fun onBindViewHolder(holder: PersonalViewHolder, position: Int) {
        holder.textTv.text = data?.get(position) ?: ""
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0

    }
}

class PersonalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val textTv: TextView = itemView.findViewById(R.id.tv_text)

}