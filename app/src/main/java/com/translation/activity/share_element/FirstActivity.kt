package com.translation.activity.share_element

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.translation.activity.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        cover.setOnClickListener {
            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(this,it,it.transitionName).toBundle()
            startActivity(Intent(this, SecondActivity::class.java),option)
        }
    }
}