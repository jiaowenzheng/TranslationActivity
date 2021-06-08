package com.translation.sample.menu

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.translation.sample.R


class PopMenuActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var blackBackgroundView: View

    private lateinit var popMenu1View: View
    private lateinit var popMenu2View: View
    private lateinit var popMenu3View: View
    private lateinit var popMenu4View: View

    private var maxHeight: Int = 0
    private var minHeight: Int = 0
    private var radius = 0f
    private var b = 0f

    private var popMenuViewList = arrayListOf<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_menu)

        maxHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200f,resources.displayMetrics).toInt()
        minHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50f,resources.displayMetrics).toInt()
        radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,25f,resources.displayMetrics)

        popMenu1View = findViewById(R.id.tv_pop_menu_1)
        popMenu2View = findViewById(R.id.tv_pop_menu_2)
        popMenu3View = findViewById(R.id.tv_pop_menu_3)
        popMenu4View = findViewById(R.id.tv_pop_menu_4)
        blackBackgroundView = findViewById(R.id.black_bg)

        //四个Menu 背景
        popMenu1View.background = createMenuBackground()
        popMenu2View.background = createMenuBackground()
        popMenu3View.background = createMenuBackground()
        popMenu4View.background = createMenuBackground()

        popMenuViewList.add(popMenu2View)
        popMenuViewList.add(popMenu3View)
        popMenuViewList.add(popMenu4View)

        //背景
        blackBackgroundView.background = GradientDrawable().apply {
            cornerRadius = radius
            setColor(resources.getColor(R.color.color_50_transparent))
        }

        popMenu1View.setOnClickListener(this)
        popMenu2View.setOnClickListener(this)
        popMenu3View.setOnClickListener(this)
        popMenu4View.setOnClickListener(this)
    }

    private fun createMenuBackground(): Drawable {
        return GradientDrawable().apply {
            cornerRadius = radius
            setColor(Color.WHITE)
            setStroke(2,Color.BLACK)
        }
    }


    private fun heightAnimation(targetView: View,startHeight: Int,endHeight: Int) {
        val valueAnimator = ValueAnimator.ofInt(startHeight, endHeight)
        valueAnimator.addUpdateListener {
            val animatorValue = it.animatedValue.toString().toInt()
            Log.i("jiao","animatorValue$animatorValue fraction="+it.animatedFraction)

            val params = targetView.layoutParams
            params.height = animatorValue
            targetView.layoutParams = params

//            val radiusFraction = it.animatedFraction * radius
//            val radius1 = it.animatedFraction / radius
//            Log.i("jiao","radiusFraction$radiusFraction radius=$radius radius1=$radius1 resultRadius=$resultRadius")
//            val gradient = targetView.background as GradientDrawable
//            gradient.cornerRadius =
//            targetView.background = gradient

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
            R.id.tv_pop_menu_1 -> {

            }
            R.id.tv_pop_menu_2 -> {
                startAnimation()
            }
            R.id.tv_pop_menu_3 -> {
                startAnimation()
            }
            R.id.tv_pop_menu_3 -> {
                startAnimation()
            }

        }
    }

    private fun startAnimation(){
        for (view in popMenuViewList){
            translationAnimation(view,100f,200)
        }
    }

    private fun translationAnimation(view: View,endY: Float,duration: Long): ObjectAnimator{
       return ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,endY).apply {
           setDuration(duration)
           interpolator = AccelerateDecelerateInterpolator()
       }
    }

}