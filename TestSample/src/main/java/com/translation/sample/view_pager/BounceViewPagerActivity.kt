package com.translation.sample.view_pager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.translation.sample.databinding.ActivityBounceViewPagerBinding

class BounceViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBounceViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBounceViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(this)
    }
}