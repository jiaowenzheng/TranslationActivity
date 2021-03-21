package com.translation.shopcartanimation.expand

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.translation.shopcartanimation.R
import com.translation.shopcartanimation.widget.CollapsedTextView

class ExpandTextViewActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_expand_text_view)

        val textView = findViewById<CollapsedTextView>(R.id.tv_text)
        textView.text = "功哥可萝莉三叶草哥阿里卡功哥可萝莉三叶草哥阿里卡功哥可萝莉三叶草哥阿里卡功哥可萝莉三" +
                "叶草哥阿里卡功哥可萝莉三叶草哥阿里卡功哥可萝莉三叶草哥阿里卡草哥阿里卡功哥可萝莉三叶草哥阿里卡"
    }
}