package com.translation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.translation.activity.explode.ExplodeActivity
import com.translation.activity.flexbox.FlexboxActivity
import com.translation.activity.share_element.FirstActivity
import com.translation.activity.slide.SlideActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListView = findViewById(R.id.list_view)

        val itemData = listOf("Explode","Slide","ShareElement","Flexbox")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,itemData)
        mListView.adapter = adapter

        mListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> toActivity(position)}

    }

    private fun toActivity(position: Int){
        when(position){
            0 -> startActivity(Intent(this,ExplodeActivity::class.java))
            1 -> startActivity(Intent(this,SlideActivity::class.java))
            2 -> startActivity(Intent(this,FirstActivity::class.java))
            3 -> startActivity(Intent(this,FlexboxActivity::class.java))
        }
    }



}