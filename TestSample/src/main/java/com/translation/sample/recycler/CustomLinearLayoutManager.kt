package com.translation.sample.recycler

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomLinearLayoutManager(context: Context, direction: Int, reverseLayout: Boolean) :
    LinearLayoutManager(context, direction, reverseLayout) {

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams?): RecyclerView.LayoutParams {

        return RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}