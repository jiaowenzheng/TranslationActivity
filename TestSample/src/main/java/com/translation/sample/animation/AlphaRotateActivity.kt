package com.translation.sample.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator.REVERSE
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.translation.sample.R

class AlphaRotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alpha_rotate)

        val firstIv = findViewById<ImageView>(R.id.iv_rotate_first)
        val secondIv = findViewById<ImageView>(R.id.iv_rotate_second)

        val animatorSet = AnimatorSet()

        val firstRotate = createRotateAnimation(firstIv)
        val firstAlpha = createAlphaAnimation(firstIv,0f,1f)

        val secondRotate = createRotateAnimation(secondIv)
        val secondAlpha = createAlphaAnimation(secondIv,1f,0f)

        animatorSet.playTogether(firstAlpha,firstRotate,secondAlpha,secondRotate)
        animatorSet.duration = 5000
        animatorSet.start()
    }

    private fun createRotateAnimation(view: View): ObjectAnimator{
        val rotateFirst = ObjectAnimator.ofFloat(view, View.ROTATION,0f,360f)
        rotateFirst.duration = 5000
        rotateFirst.interpolator = LinearInterpolator()
        rotateFirst.repeatCount = -1
        return rotateFirst
    }

    private fun createAlphaAnimation(view: View, from: Float, to: Float): ObjectAnimator{
        val alphaFirst = ObjectAnimator.ofFloat(view,View.ALPHA,from,to)
        alphaFirst.duration = 2000
        alphaFirst.interpolator = LinearInterpolator()
        alphaFirst.repeatCount = -1
        alphaFirst.repeatMode = REVERSE
        return alphaFirst
    }

}