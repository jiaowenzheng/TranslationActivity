package com.translation.shopcartanimation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.translation.shopcartanimation.auto_wrap_text.AutoWrapTextViewActivity
import com.translation.shopcartanimation.expand.ExpandTextViewActivity
import com.translation.shopcartanimation.popmenu.PopupActivity
import com.translation.shopcartanimation.recycler.RecyclerViewActivity
import java.util.regex.Pattern
import kotlin.reflect.KClass

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val flexboxLayoutManager = FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP)
        flexboxLayoutManager.alignItems = AlignItems.CENTER
        flexboxLayoutManager.justifyContent = JustifyContent.FLEX_START
        recyclerView.layoutManager = flexboxLayoutManager
        recyclerView.setHasFixedSize(true)

        val itemDecoration = FlexboxItemDecoration(this)
        itemDecoration.setDrawable(getDrawable(R.drawable.shape_flexbox_item_divider))
        recyclerView.addItemDecoration(itemDecoration)

        val adapter = GuideAdapter(getItem())

        recyclerView.addOnItemTouchListener(object : OnRecyclerItemClickListener(recyclerView) {
            override fun onItemClick(viewHolder: RecyclerView.ViewHolder?, position: Int) {
                itemClick(adapter.getData()[position])
            }
        })

        recyclerView.adapter = adapter

    }

    private fun getItem(): List<String>{
        return arrayListOf("PopMenu", "ExpandTextView", "FlexboxLayoutManager","AutoWrapTextView")
    }

    private fun itemClick(item: String){
        when(item){
            "PopMenu" -> startTargetActivity(PopupActivity::class)
            "ExpandTextView" -> startTargetActivity(ExpandTextViewActivity::class)
            "FlexboxLayoutManager" -> startTargetActivity(RecyclerViewActivity::class)
            "AutoWrapTextView" -> startTargetActivity(AutoWrapTextViewActivity::class)
        }
    }

    private fun startTargetActivity(target: KClass<out Any>){
        startActivity(Intent(GuideActivity@ this,target.java))
    }

    fun filterStringRegex(content: String?): String? {
        if (!TextUtils.isEmpty(content)) {
            val pattern = Pattern.compile("\\s*|\t|\r|\n")
            val matcher = pattern.matcher(content)
            return matcher.replaceAll("")
        }
        return content
    }

}