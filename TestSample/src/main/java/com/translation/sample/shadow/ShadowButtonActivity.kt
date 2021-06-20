package com.translation.sample.shadow

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.translation.sample.R

class ShadowButtonActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var menuFirstNormalIv: ImageView
    private lateinit var menuFirstPressedIv: ImageView
    private lateinit var menuSecondNormalIv: ImageView
    private lateinit var menuSecondPressedIv: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shadow_button)

        menuFirstNormalIv = findViewById(R.id.iv_menu_1_normal)
        menuFirstPressedIv = findViewById(R.id.iv_menu_1_pressed)
        menuSecondNormalIv = findViewById(R.id.iv_menu_2_normal)
        menuSecondPressedIv = findViewById(R.id.iv_menu_2_pressed)

        menuFirstNormalIv.setOnClickListener(this)
        menuSecondNormalIv.setOnClickListener(this)
        menuFirstPressedIv.setOnClickListener(this)
        menuSecondPressedIv.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_menu_1_normal -> {
                menu1Animation(menuFirstNormalIv,menuFirstPressedIv,menuSecondNormalIv,menuSecondPressedIv)
            }
            R.id.iv_menu_1_pressed -> {
                menu1Animation(menuFirstPressedIv,menuFirstNormalIv,menuSecondNormalIv,menuSecondPressedIv)
            }
            R.id.iv_menu_2_normal -> {
                menu1Animation(menuSecondNormalIv,menuSecondPressedIv,menuFirstNormalIv,menuFirstPressedIv)
            }
            R.id.iv_menu_2_pressed -> {
                menu1Animation(menuSecondPressedIv,menuSecondNormalIv,menuFirstNormalIv,menuFirstPressedIv)
            }
        }
    }

    private fun menu1Animation(menuNormalIv: View,menuPressed: View,lastNormalIv:View,lastPressedIv: View){
        if (lastNormalIv.alpha == 0f){
            alphaAnimation(lastNormalIv,0f,1f)
            alphaAnimation(lastPressedIv,1f,0f)
        }else if (lastPressedIv.alpha == 0f){
            alphaAnimation(lastPressedIv,0f,1f)
            alphaAnimation(lastNormalIv,1f,0f)
        }

        alphaAnimation(menuNormalIv,1f,0f)
        alphaAnimation(menuPressed,0f,1f)
    }


    private fun alphaAnimation(view: View, from: Float, to: Float) {
        ObjectAnimator.ofFloat(view, View.ALPHA, from, to).apply {
            duration = 200
            start()
        }
    }
}