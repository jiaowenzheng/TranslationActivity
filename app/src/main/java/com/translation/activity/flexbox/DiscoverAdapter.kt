package com.translation.activity.flexbox

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.translation.activity.R

/**
 * @program: TranslationActivity
 *
 * @description:
 *
 * @author: Mr.Wang
 *
 * @create: 2021-03-20 20:55
 **/
class DiscoverAdapter(private val context: Context,private val data: List<DiscoverModel>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val contentView = LayoutInflater.from(parent.context).inflate(R.layout.item_flexbox,parent,false)

        return ViewHolder(contentView)
    }

    override fun getItemCount(): Int {
        return if (data.isNullOrEmpty()) 0 else data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(context,data[position])
    }
}