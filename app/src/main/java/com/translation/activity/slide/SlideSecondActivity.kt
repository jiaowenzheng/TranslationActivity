package com.translation.activity.slide

import android.os.Bundle
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import com.translation.activity.R
import kotlinx.android.synthetic.main.activity_second.*

class SlideSecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val slide = Slide()
        slide.duration = 2000
//        slide.addTarget(android.R.id.navigationBarBackground)
//        slide.addTarget(android.R.id.statusBarBackground)

        window.enterTransition = slide
        window.exitTransition = slide

        iv_second_cover.setOnClickListener {
            onBackPressed()
        }
    }
}