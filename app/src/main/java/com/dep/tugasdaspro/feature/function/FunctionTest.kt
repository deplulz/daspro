package com.dep.tugasdaspro.feature.function

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dep.tugasdaspro.databinding.ActivityFunctionBinding

class FunctionTest : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityFunctionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFunctionBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)
    }

    private fun clear() {
        _binding!!.nama.editText!!.setText("")
        _binding!!.pinjaman.editText!!.setText("")
        _binding!!.sukuBunga.editText!!.setText("")
        _binding!!.tenor.editText!!.setText("")
        _binding!!.totalPengembalian.editText!!.setText("")
        _binding!!.cicilan.editText!!.setText("")
    }

    private fun bunga(e:Double,f:Double,g:Double): Double {
        return e*(f/100)
    }

    private fun count() {

        val a = _binding!!.pinjaman.editText!!.text.toString().toDouble()
        val b = _binding!!.sukuBunga.editText!!.text.toString().toDouble()
        val c = _binding!!.tenor.editText!!.text.toString().toDouble()
        val d = bunga(a,b,c)
        val e = a+d

        _binding!!.totalKembali = "${e.toInt()}"
        _binding!!.angsuran= "${(e/c).toInt()}"

    }

    override fun onClick(v: View?) {
        if (v == _binding!!.clear) {
             clear()
        } else if (v == _binding!!.total) {
            count()
        }
    }
}