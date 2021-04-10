package com.translation.activity.flexbox

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.flexbox.FlexboxLayoutManager
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
class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val cover = view.findViewById<ImageView>(R.id.iv_cover)

    fun bindData(context: Context,discoverModel: DiscoverModel){
        Glide.with(context).load(discoverModel.cover).into(cover)

        val params = cover.layoutParams
        if (params is FlexboxLayoutManager.LayoutParams){
            params.flexGrow = 1.0f
//            params.flexBasisPercent =
        }
    }

}