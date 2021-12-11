package com.dep.tugasdaspro.feature.detil_list_mahasiswa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dep.tugasdaspro.databinding.ActivityDetilListMahasiswaBinding
import com.dep.tugasdaspro.feature.config.PROCESS
import com.dep.tugasdaspro.feature.config.REJECTED
import com.dep.tugasdaspro.feature.config.arrayMhs
import com.dep.tugasdaspro.feature.detil_list_mahasiswa.adapter.DetilMahasiswaAdapter
import com.dep.tugasdaspro.feature.detil_list_mahasiswa.dao.DAOMahasiswa

class DetilListMahasiswa : AppCompatActivity() {
    private var _binding: ActivityDetilListMahasiswaBinding? = null
    private val _adapter by lazy { DetilMahasiswaAdapter() }
    private val _mData by lazy { arrayMhs }
    private val _tempData by lazy { ArrayList<DAOMahasiswa>() }
    private lateinit var _DAO: DAOMahasiswa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetilListMahasiswaBinding.inflate(layoutInflater)
        prepareData()
        setContentView(_binding!!.root)
    }

    private fun prepareData() {
        _adapter.notifyDataSetChanged()
        _binding!!.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@DetilListMahasiswa, LinearLayoutManager.VERTICAL, false)
            adapter = _adapter
        }
        when {
            intent.extras!!.getString("flag") == PROCESS -> {
                getProcessData()
            }
            intent.extras!!.getString("flag") == REJECTED -> {
                getRejectedData()
            }
            intent.extras!!.getString("flag") == REJECTED -> {
                getAprovedData()
            }
            else -> {
                getAllData()
            }
        }
        _adapter.setData(this, _tempData)
        _adapter.notifyDataSetChanged()
    }

    private fun getAllData() {
        for (i in 0 until _mData.length()) {
            val objects = _mData.getJSONObject(i)
            _DAO = DAOMahasiswa(
                objects.getString("name"),
                objects.getString("address"),
                objects.getString("school"),
                objects.getString("gender"),
                objects.getString("aproved")
            )
            _tempData.add(_DAO)
        }
    }

    private fun getAprovedData() {
        for (i in 0 until _mData.length()) {
            val objects = _mData.getJSONObject(i)
            if (objects.getString("aproved") == "1") {
                _DAO = DAOMahasiswa(
                    objects.getString("name"),
                    objects.getString("address"),
                    objects.getString("school"),
                    objects.getString("gender"),
                    objects.getString("aproved")
                )
                _tempData.add(_DAO)
            }
        }
    }

    private fun getRejectedData() {
        for (i in 0 until _mData.length()) {
            val objects = _mData.getJSONObject(i)
            if (objects.getString("aproved") == "2") {
                _DAO = DAOMahasiswa(
                    objects.getString("name"),
                    objects.getString("address"),
                    objects.getString("school"),
                    objects.getString("gender"),
                    objects.getString("aproved")
                )
                _tempData.add(_DAO)
            }
        }
    }

    private fun getProcessData() {
        for (i in 0 until _mData.length()) {
            val objects = _mData.getJSONObject(i)
            if (objects.getString("aproved") == "0") {
                _DAO = DAOMahasiswa(
                    objects.getString("name"),
                    objects.getString("address"),
                    objects.getString("school"),
                    objects.getString("gender"),
                    objects.getString("aproved")
                )
                _tempData.add(_DAO)
            }
        }
    }
}