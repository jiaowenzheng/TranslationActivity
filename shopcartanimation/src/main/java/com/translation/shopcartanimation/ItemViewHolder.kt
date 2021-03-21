package com.translation.shopcartanimation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
   val item = itemView.findViewById<TextView>(R.id.tv_item)
}