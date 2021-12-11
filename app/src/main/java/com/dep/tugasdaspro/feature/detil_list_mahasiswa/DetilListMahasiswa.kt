package com.dep.tugasdaspro.feature.detil_list_mahasiswa

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dep.tugasdaspro.databinding.ActivityDetilListMahasiswaBinding
import com.dep.tugasdaspro.feature.config.*
import com.dep.tugasdaspro.feature.detil_list_mahasiswa.adapter.DetilMahasiswaAdapter
import com.dep.tugasdaspro.feature.detil_list_mahasiswa.dao.DAOMahasiswa

class DetilListMahasiswa : AppCompatActivity() {
    private var _binding: ActivityDetilListMahasiswaBinding? = null
    private val _adapter by lazy { DetilMahasiswaAdapter() }
    private val _mData by lazy { arrayMhs }
    private val _tempData by lazy { ArrayList<DAOMahasiswa>() }
    private lateinit var _DAO: DAOMahasiswa
    private val _updateJobs by lazy { UpdateData() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetilListMahasiswaBinding.inflate(layoutInflater)
        prepareData()
        setContentView(_binding!!.root)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(_updateJobs, IntentFilter(JOB_RECEIVER))
    }

    private fun prepareData() {
        _tempData.clear()
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
            intent.extras!!.getString("flag") ==  ACCEPTED-> {
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
                objects.getString("nilai"),
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
                    objects.getString("nilai"),
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
                    objects.getString("nilai"),
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
                    objects.getString("nilai"),
                    objects.getString("aproved")
                )
                _tempData.add(_DAO)
            }
        }
    }

    inner class UpdateData : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            prepareData()
        }

    }
}