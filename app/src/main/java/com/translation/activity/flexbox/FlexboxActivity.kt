package com.translation.activity.flexbox

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.translation.activity.R
import java.io.ByteArrayOutputStream

/**
 * @program: TranslationActivity
 *
 * @description:
 *
 * @author: Mr.Wang
 *
 * @create: 2021-03-20 19:31
 **/

class FlexboxActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_flex_box)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.setHasFixedSize(true)
        val flexboxLayoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }

        recyclerView.layoutManager = flexboxLayoutManager

        val data = parseData()

        recyclerView.adapter = DiscoverAdapter(this,data)

    }

    private fun parseData(): List<DiscoverModel>{

        val inputStream = assets.open("data.json")

        val outputStream = ByteArrayOutputStream()

        val buf = ByteArray(1024)
        var length = 0
        length = inputStream.read(buf)

        while (length != -1) {
            outputStream.write(buf, 0, length)
            length = inputStream.read(buf)
        }

        outputStream.close()
        inputStream.close()

        return Gson().fromJson(outputStream.toString(),object :TypeToken<List<DiscoverModel>>(){}.type)
    }

}

