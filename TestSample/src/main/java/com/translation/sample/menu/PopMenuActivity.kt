package com.translation.sample.menu

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.os.postDelayed
import com.translation.sample.R


class PopMenuActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var blackBackgroundView: View

    private lateinit var popMenu1View: View
    private lateinit var popMenu2View: View
    private lateinit var popMenu3View: View
    private lateinit var popMenu4View: View

    private var totalHeight: Int = 0
    private var maxHeight: Int = 0
    private var minHeight: Int = 0
    private var radius = 0f
    private var space: Int = 0

    private var isExpand = false

    private var popMenuViewList = arrayListOf<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_menu)

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

        popMenuViewList.add(popMenu4View)
        popMenuViewList.add(popMenu3View)
        popMenuViewList.add(popMenu2View)

        maxHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200f,resources.displayMetrics).toInt()
        minHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50f,resources.displayMetrics).toInt()
        radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,35f,resources.displayMetrics)
        space = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20f,resources.displayMetrics).toInt()

        val size = popMenuViewList.size
        totalHeight = size * popMenu2View.height + size * space

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
                showMenuAnimation()
            }
            R.id.tv_pop_menu_2 -> {
                showMenuAnimation()
            }
            R.id.tv_pop_menu_3 -> {
                showMenuAnimation()
            }
            R.id.tv_pop_menu_3 -> {
                showMenuAnimation()
            }

        }
    }

    private fun showMenuAnimation(){
        if (isExpand){
            return
        }
        isExpand = true
        val size = popMenuViewList.size
        for (i in 0 until size){
            Log.i("jiao","showMenuAnimation i=$i")
            val view = popMenuViewList[i]
            view.visibility = View.INVISIBLE
            Handler().postDelayed({
                view.visibility = View.VISIBLE
                var height = totalHeight

                if (i != 0) {
                    height = totalHeight - view.height * i - (space * i)
                }

                translationAnimation(view,-height.toFloat(),200)
            }, (i * 50).toLong())
        }
    }

    private fun closeMenuAnimation(){
        val size = popMenuViewList.size
        for (i in size downTo 0 step 1){

            val view = popMenuViewList[i]

            Handler().postDelayed({
                view.visibility = View.VISIBLE

                translationAnimation(view,0f,200)
            }, (i * 50).toLong())
        }


    }

    private fun translationAnimation(view: View,endY: Float,duration: Long) {
        val objectAnimator = ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,endY).apply {
            setDuration(duration)
            interpolator = AccelerateDecelerateInterpolator()
        }
        objectAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationCancel(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                TODO("Not yet implemented")
            }

        })
        objectAnimator.start()
    }

}