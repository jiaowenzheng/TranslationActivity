package com.translation.sample

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.View

import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val banner = findViewById<ImageView>(R.id.iv_banner)
        val startBtn = findViewById<Button>(R.id.btn_start)
        val rootView = findViewById<ConstraintLayout>(R.id.root_view)

        startBtn.setOnClickListener {
            val screenBitmap = getBitmap(banner)

            if (screenBitmap != null){
                val coverIv = ImageView(this)
                coverIv.setImageBitmap(screenBitmap);

                val params = ConstraintLayout.LayoutParams(banner.width, banner.height)
                params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                params.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
                params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID

                rootView.addView(coverIv, params)

                val x = ObjectAnimator.ofFloat(coverIv,View.X,1f,0.1f)
                val y = ObjectAnimator.ofFloat(coverIv,View.Y,1f,0.1f)

                val scaleX = ObjectAnimator.ofFloat(coverIv,View.SCALE_X,1f,0.1f)
                val scaleY = ObjectAnimator.ofFloat(coverIv,View.SCALE_Y,1f,0.1f)

                val animatorSet = AnimatorSet()
                animatorSet.play(x).with(y).with(scaleX).with(scaleY)
                animatorSet.duration = 200
                animatorSet.interpolator = DecelerateInterpolator()
                animatorSet.start()

//                val location
//                val location = coverIv.getLocationInWindow()
//
//
//                ViewAnimator.animate(coverIv).path().accelerate().duration(400).onStop {
//                    rootView.removeView(coverIv)
//                }.start()

            }
        }
    }


    private fun getBitmap(view: View?): Bitmap?{
        if (view == null) return null

        var screenshot = Bitmap.createBitmap(view.width,view.height,Bitmap.Config.RGB_565)
        val canvas = Canvas(screenshot)
        canvas.translate((-view.scrollX).toFloat(), (-view.scrollY).toFloat())
        view.draw(canvas)

        return screenshot
    }
}