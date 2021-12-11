package com.dep.tugasdaspro.feature.home

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dep.tugasdaspro.databinding.FragmentHomeBinding
import com.dep.tugasdaspro.feature.config.arrayMhs
import com.dep.tugasdaspro.feature.config.arrayMhsApproved

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
        for (i in 0 until arrayMhsApproved.length()) {
            if (arrayMhsApproved.getJSONObject(i).has("aproved")) {
                when {
                    arrayMhsApproved.getJSONObject(i).get("aproved") == 1 -> {
                        _aproved += 1
                    }
                    arrayMhsApproved.getJSONObject(i).get("aproved") == 2 -> {
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