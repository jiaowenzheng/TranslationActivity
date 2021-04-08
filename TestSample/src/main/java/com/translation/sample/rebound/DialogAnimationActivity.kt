package com.translation.sample.rebound

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.translation.sample.R
import com.translation.sample.rebound.dialog.MatchingDialog

class DialogAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_animation)

        val button = findViewById<Button>(R.id.btn_dialog)

        button.setOnClickListener {
            val dialog =
                MatchingDialog()
            dialog.show(supportFragmentManager,"")
        }
    }
}