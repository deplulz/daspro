package com.dep.tugasdaspro.feature.praktek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dep.tugasdaspro.databinding.FragmentPraktekBinding
import com.dep.tugasdaspro.feature.function.FunctionTest

class PraktekFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPraktekBinding? = null
    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPraktekBinding.inflate(inflater, container, false)
        _binding!!.functions.setOnClickListener (this)
        root = _binding!!.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        val intent = Intent(requireActivity(), FunctionTest::class.java)
        requireActivity().startActivity(intent)
    }
}