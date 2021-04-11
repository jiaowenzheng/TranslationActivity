package com.translation.sample.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.translation.sample.R
import java.util.*

class RecyclerViewActivity :AppCompatActivity() {

    private lateinit var mAdapter: VerticalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val list: MutableList<Entity> = ArrayList()
        for (i in 1..10) {
            val entity = Entity()
            entity.title = "title$i"
            val innerEntities: MutableList<Entity.InnerEntity> = ArrayList<Entity.InnerEntity>()
            for (j in 1..70) {
                innerEntities.add(
                    Entity.InnerEntity(
                        "添 （2-$j）",
                        if (j % 3 == 0) R.mipmap.ic_launcher_round else R.mipmap.ic_launcher
                    )
                )
            }
            entity.innerEntities = innerEntities
            list.add(entity)
        }

        mAdapter = VerticalAdapter(R.layout.item_label_checked_list, list)

        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mAdapter
    }
}