package com.translation.sample.auto_wrap_text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.translation.sample.R
import com.translation.sample.widget.AutoWrapTextView

class AutoWrapTextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_wrap_text_view)

        val textView = findViewById<AutoWrapTextView>(R.id.tv_auto_text_view)

        val text ="""“森系哥特（Woodland Goth）”又名“暗黑仙女美学（Dark Fairy-core）”是一"""


        textView.setText(text)

    }
}