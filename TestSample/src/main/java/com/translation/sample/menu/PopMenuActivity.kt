package com.translation.sample.menu

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
import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
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

        maxHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200f,resources.displayMetrics).toInt()
        minHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50f,resources.displayMetrics).toInt()
        radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,35f,resources.displayMetrics)
        space = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20f,resources.displayMetrics).toInt()

        popMenu1View = findViewById(R.id.tv_pop_menu_1)
        popMenu2View = findViewById(R.id.tv_pop_menu_2)
        popMenu3View = findViewById(R.id.tv_pop_menu_3)
        popMenu4View = findViewById(R.id.tv_pop_menu_4)
        blackBackgroundView = findViewById(R.id.black_bg)

        //四个Menu 背景
        popMenu1View.background = createMenuBackground(radius)
        popMenu2View.background = createMenuBackground(radius)
        popMenu3View.background = createMenuBackground(radius)
        popMenu4View.background = createMenuBackground(radius)

        popMenuViewList.add(popMenu4View)
        popMenuViewList.add(popMenu3View)
        popMenuViewList.add(popMenu2View)

        popMenu1View.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                popMenu1View.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val size = popMenuViewList.size
                totalHeight = size * popMenu2View.height + size * space
            }
        })

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

    private fun createMenuBackground(radius: Float): Drawable {
        return GradientDrawable().apply {
            cornerRadius = radius
            setColor(Color.WHITE)
        }
    }

    private fun changeHeightAnimation(targetView: View, startHeight: Int, endHeight: Int) {
        val valueAnimator = ValueAnimator.ofInt(startHeight, endHeight)
        valueAnimator.addUpdateListener {
            val animatorValue = it.animatedValue.toString().toInt()
            Log.i("jiao","animatorValue$animatorValue fraction="+it.animatedFraction)

            val params = targetView.layoutParams
            params.height = animatorValue
            targetView.layoutParams = params
        }

        valueAnimator.interpolator = AccelerateDecelerateInterpolator()
        valueAnimator.setTarget(targetView)
        valueAnimator.duration = 300
        valueAnimator.start()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.black_bg -> {
                if (blackBackgroundView.height >= maxHeight){
                    changeHeightAnimation(blackBackgroundView,maxHeight,minHeight)
                }else{
                    changeHeightAnimation(blackBackgroundView,minHeight,maxHeight)
                }
            }
            R.id.tv_pop_menu_1, R.id.tv_pop_menu_2,R.id.tv_pop_menu_3,R.id.tv_pop_menu_3-> {
                changeWidthAnimation()
            }
        }
    }

    private fun changeWidthAnimation(){
        val startWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90f,resources.displayMetrics).toInt()
        val endWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,110f,resources.displayMetrics).toInt()
        val valueAnimator = ObjectAnimator.ofInt(startWidth, endWidth)
        valueAnimator.addUpdateListener {
            val params = blackBackgroundView.layoutParams as RelativeLayout.LayoutParams
            params.width = it.animatedValue as Int
            blackBackgroundView.layoutParams = params
        }
        valueAnimator.duration = 300
        valueAnimator.start()

        changeHeightAnimation(blackBackgroundView,minHeight,totalHeight + popMenu1View.height + 30)
        translationMenuAnimation()
    }

    private fun translationMenuAnimation(){
        if (isExpand){
            closeMenuAnimation()
        }else{
            showMenuAnimation()
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
            Handler().post{
                view.visibility = View.VISIBLE
                var height = totalHeight

                if (i != 0) {
                    height = totalHeight - view.height * i - (space * i)
                }

                Log.i("jiao","showMenuAnimation height = $height totalHeight=$totalHeight")

                translationAnimation(view,-height.toFloat(),300)
            }
        }
    }

    private fun closeMenuAnimation(){
        for (view in popMenuViewList){
            Handler().post{
                view.visibility = View.VISIBLE

                translationAnimation(view,0f,300)
            }
        }
        isExpand = false
    }

    private fun translationAnimation(view: View,endY: Float,duration: Long) {
        val objectAnimator = ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,endY).apply {
            setDuration(duration)
            interpolator = AccelerateDecelerateInterpolator()
        }

        objectAnimator.start()
    }

}