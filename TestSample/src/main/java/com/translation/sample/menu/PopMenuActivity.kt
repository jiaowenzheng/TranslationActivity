package com.translation.sample.menu

import android.R.attr.animation
import android.R.attr.height
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.translation.sample.R


class PopMenuActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var textView: TextView
    private lateinit var blackBackgroundView: View

    private var maxHeight: Int = 0
    private var minHeight: Int = 0
    private var radius = 0f
    private var b = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_menu)

        maxHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200f,resources.displayMetrics).toInt()
        minHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50f,resources.displayMetrics).toInt()
        radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,25f,resources.displayMetrics)

        b = minHeight / radius

        textView = findViewById(R.id.tv_pop_menu)
        blackBackgroundView = findViewById(R.id.black_bg)

        val textViewBackground =  GradientDrawable().apply {
            cornerRadius = radius
            setColor(Color.WHITE)
            setStroke(2,Color.BLACK)
        }

        val blackBackground =  GradientDrawable().apply {
            cornerRadius = radius
            setColor(resources.getColor(R.color.color_50_transparent))
        }

        textView.background = textViewBackground
        blackBackgroundView.background = blackBackground
        blackBackgroundView.setOnClickListener(this)

//        blackBackgroundView.layoutParams.height = (dp * 3).toInt()

        textView.setOnClickListener(this)

    }

    private fun heightAnimation(targetView: View,startHeight: Int,endHeight: Int) {
        val valueAnimator = ValueAnimator.ofInt(startHeight, endHeight)
        valueAnimator.addUpdateListener {
            val animatorValue = it.animatedValue.toString().toInt()
            Log.i("jiao","animatorValue$animatorValue fraction="+it.animatedFraction)

            val params = targetView.layoutParams
            params.height = animatorValue
            targetView.layoutParams = params

            val resultRadius = animatorValue * b

            val radiusFraction = it.animatedFraction * radius
            val radius1 = it.animatedFraction / radius
            Log.i("jiao","radiusFraction$radiusFraction radius=$radius radius1=$radius1 resultRadius=$resultRadius")
            val gradient = targetView.background as GradientDrawable
            gradient.cornerRadius = resultRadius.toFloat()
            targetView.background = gradient

        }

        valueAnimator.interpolator = AccelerateDecelerateInterpolator()
        valueAnimator.setTarget(targetView)
        valueAnimator.duration = 500
        valueAnimator.start()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.black_bg -> {
                if (blackBackgroundView.height >= maxHeight){
                    heightAnimation(blackBackgroundView,maxHeight,minHeight)
                }else{
                    heightAnimation(blackBackgroundView,minHeight,maxHeight)
                }
            }
        }
    }

}