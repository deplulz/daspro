package com.dep.tugasdaspro.feature.decision

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dep.tugasdaspro.databinding.ActivityDecissionBinding

class Decission : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityDecissionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDecissionBinding.inflate(layoutInflater, )
        setContentView(_binding!!.root)
    }

    private fun process() {
        val nilai = _binding!!.nilai.editText!!.text.toString().toInt()
        var res = ""
        when (nilai) {
            in 0..15 -> {
                res = "Hasil Konfersi nilai $nilai adalah E"
            }
            in 16..40 -> {
                res = "Hasil Konfersi nilai $nilai adalah D"
            }
            in 41..60 -> {
                res = "Hasil Konfersi nilai $nilai adalah C"
            }
            in 61..80 -> {
                res = "Hasil Konfersi nilai $nilai adalah B"
            }
            in 81..100 -> {
                res = "Hasil Konfersi nilai $nilai adalah A"
            }
            else -> {
                res = "Hasil Konfersi nilai $nilai TIDAK ADA"
            }
        }
        _binding!!.results = res
    }

    override fun onClick(v: View?) {
        if (v!! == _binding!!.process) {
            process()
        }
    }
}