package com.translation.sample.behavior

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.translation.sample.R

/**
 * @program: TranslationActivity
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-06 10:50
 */
class FlingBehaviorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fling_behavior)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = PageAdapter(supportFragmentManager)

        tabLayout.setupWithViewPager(viewPager)

//        supportFragmentManager.beginTransaction().
//                replace(R.id.container, FlingBehaviorFragment()).commitAllowingStateLoss();

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//
//        val data = arrayListOf<String>()
//
//        for (i in 1..30){
//            data.add(i.toString())
//        }
//
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//
//        recyclerView.adapter = ItemAdapter(data)
    }
}