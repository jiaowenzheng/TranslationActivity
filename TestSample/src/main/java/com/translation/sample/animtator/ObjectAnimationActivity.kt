package com.translation.sample.animtator

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.translation.sample.R

/**
 * @program: TranslationActivity
 *
 * @description:
 *
 * @author: Mr.Wang
 *
 * @create: 2021-06-26 22:15
 **/
class ObjectAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            val viewWrapper = ViewWrapper(it)
            val startWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100f,resources.displayMetrics)
            val endWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200f,resources.displayMetrics)
            val holder = PropertyValuesHolder.ofInt("realWidth",startWidth.toInt(),endWidth.toInt())
            val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(viewWrapper,holder)
            objectAnimator.duration = 300
            objectAnimator.start()
        }



    }
}