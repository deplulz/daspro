package com.dep.tugasdaspro.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dep.tugasdaspro.databinding.FragmentHomeBinding
import com.dep.tugasdaspro.feature.config.arrayMhs

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var _rejected = 0
    private var _aproved = 0
    private var _needProccess = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        for (i in 0 until arrayMhs.length()) {
            if (arrayMhs.getJSONObject(i).has("aproved")) {
                when {
                    arrayMhs.getJSONObject(i).getString("aproved") == "1" -> {
                        _aproved += 1
                    }
                    arrayMhs.getJSONObject(i).getString("aproved") == "2" -> {
                        _rejected += 1
                    }
                    else -> {
                        _needProccess += 1
                    }
                }
            }
        }


        _binding!!.mhsDftar = "${arrayMhs.length()}"
        _binding!!.needProcess = "$_needProccess"
        _binding!!.approved = "$_aproved"
        _binding!!.rejected = "$_rejected"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}