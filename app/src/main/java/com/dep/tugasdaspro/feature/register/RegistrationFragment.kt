package com.dep.tugasdaspro.feature.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dep.tugasdaspro.databinding.FragmentRegistrationBinding
import com.dep.tugasdaspro.feature.config.arrayMhs
import org.json.JSONObject

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private lateinit var root: View
    private var gender = "L"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        root = _binding!!.root
        prepareData()
        return root
    }

    private fun prepareData() {
        _binding!!.gender.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == group.checkedRadioButtonId) {
                gender = "L"
            } else {
                gender = "P"
            }
        }

        _binding!!.regis.setOnClickListener {
            save()
        }
        _binding!!.clearView.setOnClickListener {
            clear()
        }

    }

    private fun clear() {
        _binding!!.nama = ""
        _binding!!.address = ""
        _binding!!.school = ""
        _binding!!.gender.clearCheck()
        _binding!!.point = ""

        _binding!!.name.requestFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun save() {
        val dataMhs = JSONObject()
        dataMhs.put("name", _binding!!.name.editText!!.text.toString())
        dataMhs.put("address", _binding!!.from.editText!!.text.toString())
        dataMhs.put("school", _binding!!.fromSchool.editText!!.text.toString())
        dataMhs.put("gender", gender)
        dataMhs.put("nilai", _binding!!.nilaiAkhir.editText!!.text.toString())
        dataMhs.put("aproved", 0)
        arrayMhs.put(dataMhs)
        clear()
    }
}