package com.translation.shopcartanimation.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.translation.shopcartanimation.R

class RotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate)

        val rotateIv = findViewById<ImageView>(R.id.iv_guide_circle)

        val rotateAnimation = ObjectAnimator.ofFloat(rotateIv,View.ROTATION,0f,360f)
        rotateAnimation.interpolator = LinearInterpolator()
        rotateAnimation.duration = 5000
        rotateAnimation.repeatCount = -1
        rotateAnimation.start()

        rotateIv.setOnTouchListener { v, event ->
            Log.i("jiao","event action="+event.action)
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    v.animate()
                        .scaleX(0.8f)
                        .scaleY(0.8f)
                        .setDuration(150)
                        .start()
                }

                    MotionEvent.ACTION_CANCEL,
                    MotionEvent.ACTION_UP ->{
                    v.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(150)
                        .start()
                }
            }
            false
        }

        val scaleAnimation = ObjectAnimator.ofFloat(rotateIv,View.SCALE_X,1f,0.8f)


//        val rotate  = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f)

    }
}