package com.translation.activity.explode

import android.os.Bundle
import android.transition.Explode
import androidx.appcompat.app.AppCompatActivity
import com.translation.activity.R
import kotlinx.android.synthetic.main.activity_second.*

class ExplodeSecondActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val explode = Explode()
        explode.duration = 2000;

        window.enterTransition = explode
        window.exitTransition = explode

        iv_second_cover.setOnClickListener {
            onBackPressed()
        }
    }
}