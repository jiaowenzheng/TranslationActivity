package com.translation.sample.behavior

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.translation.sample.R

/**
 * @program: TranslationActivity
 *
 * @description:
 *
 * @author: Mr.Wan
 *
 * @create: 2021-06-06 11:00
 **/
class FlingBehaviorFragment : Fragment() {

    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_fling_behavior, null)
        }
        val parent = rootView!!.parent as? ViewGroup
        parent?.removeView(rootView)
        return rootView

//        return inflater.inflate(R.layout.fragment_fling_behavior,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val data = arrayListOf<String>()

        for (i in 1..30){
            data.add(i.toString())
        }

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        recyclerView.adapter = ItemAdapter(data)

    }
}