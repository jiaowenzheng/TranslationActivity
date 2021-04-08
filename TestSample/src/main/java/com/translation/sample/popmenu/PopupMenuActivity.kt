package com.translation.sample.popmenu

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.translation.sample.R

class PopupMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)

        val button1 = findViewById<TextView>(R.id.tv_button_1)
        val button2 = findViewById<TextView>(R.id.tv_button_2)
        val button3 = findViewById<TextView>(R.id.tv_button_3)

        button1.setOnClickListener {
            showPop(it)
        }

        button2.setOnClickListener {
            showPop(it)
        }

        button3.setOnClickListener {
            showPop(it)
        }
    }

    fun showPop(button: View){
        val view = layoutInflater.inflate(R.layout.popup_layout,null)
        val contentTv = view.findViewById<TextView>(R.id.tv_content)
        val topLayout = view.findViewById<View>(R.id.top_layout)
        val arrowIv = view.findViewById<View>(R.id.iv_up_arrow)

        val drawable = GradientDrawable()
        drawable.setColor(Color.WHITE)
        drawable.cornerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,6f,resources.displayMetrics)
        topLayout.background = drawable

        val popup = PopupWindow(this)
        popup.contentView = view
        popup.setBackgroundDrawable(ColorDrawable())
        popup.isOutsideTouchable = true


        val w = resources.displayMetrics.widthPixels * 0.618f
        val h = w / 2.97f
        val arrowHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20f,resources.displayMetrics)

        topLayout.layoutParams.width = w.toInt()
        topLayout.layoutParams.height = h.toInt()

        val offsetX = button.width

        //宽度比值
        val factor = button.width / w
        //button 中点坐标
        val centerX = button.width / 2
        //计算出popWindow 对就的宽度
        val ww = centerX * factor + arrowHeight
        //计算popWindow 百分比
        val wwPercent = ww / w

        val params = arrowIv.layoutParams as ConstraintLayout.LayoutParams
        params.horizontalBias = wwPercent
        arrowIv.layoutParams = params

        Log.i("jiao","centerX =$centerX factor=$factor ww=$ww percent=$wwPercent")

        val offsetY = arrowHeight * 2 + 30 + button.height + h

        Log.i("jiao","height="+button.height+" h="+h+" arrow height="+arrowHeight+" w="+w+" button width="+button.width)

    }

}