package com.dep.tugasdaspro.feature.process_registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dep.tugasdaspro.databinding.ActivityDecissionBinding
import com.dep.tugasdaspro.databinding.ActivityFunctionBinding
import com.dep.tugasdaspro.databinding.ActivityProcessRegisBinding
import com.dep.tugasdaspro.feature.config.JOB_RECEIVER
import com.dep.tugasdaspro.feature.config.arrayMhs
import org.json.JSONObject

@Suppress("UNCHECKED_CAST")
class ProcessRegis : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityProcessRegisBinding? = null

    private var indexData = 0
    private lateinit var data: HashMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProcessRegisBinding.inflate(layoutInflater)
        getData()
        setContentView(_binding!!.root)
    }

    private fun getData() {
        if (intent.hasExtra("data")) {
            intent.extras!!.get("data")
        }
        data = HashMap()
        data = intent.extras!!.get("data") as HashMap<String, String>

        indexData = data["dataIndex"]!!.toInt()
        _binding!!.nama = data["name"]
        _binding!!.address = data["address"]
        _binding!!.school = data["school"]
        _binding!!.male = data["gender"] == "L"
        _binding!!.female = data["gender"] == "P"
        _binding!!.needProcess = data["aproved"] == "0"
        _binding!!.point = data["nilai"]
    }

    override fun onClick(v: View?) {
        val dataMhs = JSONObject()
        dataMhs.put("name", data["name"])
        dataMhs.put("address", data["address"])
        dataMhs.put("school", data["school"] )
        dataMhs.put("gender", data["gender"] )
        dataMhs.put("nilai", data["nilai"] )

        if (v == _binding!!.approve) {
            dataMhs.put("aproved", "1" )
        } else {
            dataMhs.put("aproved", "2" )
        }
        arrayMhs.remove(indexData)
        arrayMhs.put(dataMhs)
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        sendBroadcast(Intent(JOB_RECEIVER))
        finish()
    }
}