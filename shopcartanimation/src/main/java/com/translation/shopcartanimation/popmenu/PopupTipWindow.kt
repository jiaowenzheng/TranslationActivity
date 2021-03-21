package com.translation.shopcartanimation.popmenu

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.PopupWindow
import com.translation.shopcartanimation.R

class PopupTipWindow(context: Context) : PopupWindow(){

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.popup_layout, null)
        contentView = view
        setBackgroundDrawable(ColorDrawable())
        isTouchable = true
        isFocusable = true
        isOutsideTouchable = true

        width = context.resources.displayMetrics.widthPixels / 2
    }


}