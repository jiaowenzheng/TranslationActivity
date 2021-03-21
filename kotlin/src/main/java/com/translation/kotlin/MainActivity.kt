package com.translation.kotlin

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.translation.kotlin.lazy.MESSAGE_MSG
import com.translation.kotlin.lazy.ViewProvider
import com.translation.kotlin.lazy.bindView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(), ViewProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = bindView<TextView>(R.id.tv_text)
        val rippleLayout = findViewById<LinearLayout>(R.id.ripple_layout)

        Log.i("jiao", " textView = ${textView == null} $MESSAGE_MSG")

        parse()

        val states = Array(1) { IntArray(1) }
        states[0] = intArrayOf(android.R.attr.state_pressed)

        val color = intArrayOf(resources.getColor(R.color.design_default_color_primary))

        val colorStateList = ColorStateList(states,color)
        val colorDrawable = ColorDrawable(resources.getColor(R.color.design_default_color_secondary))
        val rippleDrawable = RippleDrawable(colorStateList,colorDrawable,null)
        rippleLayout.background = rippleDrawable


    }

    fun parse(){
     val json = getFileString(this, "json.json")
     val productModel = JSON.parseObject(json, ProductModel::class.java)

    }

    /**
     * 获取asset 文件夹下的文件的内容
     *
     * @param context
     * @param fileName
     * @return
     */
    fun getFileString(context: Context, fileName: String?): String? {
        val stringBuilder = StringBuilder()
        try {
            val assetManager = context.assets
            val bf = BufferedReader(
                InputStreamReader(
                    assetManager.open(fileName!!)
                )
            )
            var line: String?
            while (bf.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }

    override fun provide(): View {
        return window.decorView.findViewById(R.id.ll_root)
    }

    companion object {
        val WHAT = 1
    }

}