package com.translation.sample.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomScrollView(context: Context?,attrs: AttributeSet?) : View(context,attrs){

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.i("jiao","dispatchTouchEvent action=${event?.action}")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        Log.i("jiao","onTouchEvent action=${event?.action}")
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.YELLOW)
    }
}