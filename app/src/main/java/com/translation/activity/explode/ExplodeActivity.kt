package com.translation.activity.explode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.translation.activity.R
import kotlinx.android.synthetic.main.activity_first.*

class ExplodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explode)

        cover.setOnClickListener {
            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
            startActivity(Intent(this,ExplodeSecondActivity::class.java),option.toBundle())
        }
    }
}