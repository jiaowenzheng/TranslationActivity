package com.translation.activity.share_element

import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.translation.activity.R

class SecondActivity:AppCompatActivity() {

    private lateinit var mCover: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mCover = findViewById(R.id.iv_second_cover)
        mCover.setOnClickListener {
            onBackPressed()
        }
    }
}