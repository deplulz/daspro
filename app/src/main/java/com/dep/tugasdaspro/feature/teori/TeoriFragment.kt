package com.dep.tugasdaspro.feature.teori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dep.tugasdaspro.databinding.FragmentTeoriBinding
import com.dep.tugasdaspro.feature.teori.adapter.TeoriAdapter

class TeoriFragment : Fragment() {

    private var _binding: FragmentTeoriBinding? = null
    private lateinit var root: View
    private lateinit var mAdapter: TeoriAdapter

    private val mData: ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTeoriBinding.inflate(inflater, container, false)
        root = _binding!!.root
        prepareData()
        return root
    }

    private fun prepareData() {
        mData.add("percabangan")
        mData.add("looping")
        mAdapter = TeoriAdapter()
        mAdapter.notifyDataSetChanged()

        _binding!!.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        mAdapter.setData(requireActivity(),mData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}