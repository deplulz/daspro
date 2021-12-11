package com.dep.tugasdaspro.feature.teori

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dep.tugasdaspro.databinding.FragmentListMahasiswaBinding
import com.dep.tugasdaspro.databinding.FragmentTeoriBinding
import com.dep.tugasdaspro.feature.config.mData
import com.dep.tugasdaspro.feature.list_mahasiswa.adapter.MahasiswaAdapter
import com.dep.tugasdaspro.feature.teori.adapter.TeoriAdapter

class ListMahasiswa : Fragment() {

    private var _binding: FragmentListMahasiswaBinding? = null
    private lateinit var root: View
    private lateinit var mAdapter: MahasiswaAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListMahasiswaBinding.inflate(inflater, container, false)
        root = _binding!!.root
        prepareData()
        return root
    }

    private fun prepareData() {

        mAdapter = MahasiswaAdapter()
        mAdapter.notifyDataSetChanged()

        _binding!!.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = mAdapter
        }

        mAdapter.setData(requireActivity(), mData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}