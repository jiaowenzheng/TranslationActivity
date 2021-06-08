package com.translation.sample.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.translation.sample.databinding.FragmentPagerIndexBinding

class PagerFragment : Fragment() {

    private var  binding: FragmentPagerIndexBinding? = null

    companion object {

        fun newInstance(position: Int): Fragment{
            val args = Bundle()
            args.putInt("position", position)
            val fragment = PagerFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerIndexBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null){

            val data = arrayListOf("1", "你好", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
            binding?.recyclerView?.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = PersonalAdapter(data)
            }

            binding?.recyclerView?.setOverScrollMode(View.OVER_SCROLL_NEVER)

            // Vertical
//            ElasticityHelper.setUpOverScroll(binding?.recyclerView, ORIENTATION.VERTICAL)

//            when(bundle.getInt("position")){
//                1 -> binding?.tvText?.text = "这是第一页"
//                2 -> binding?.tvText?.text = "这是第二页"
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}