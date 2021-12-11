package com.dep.tugasdaspro.feature.looping

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dep.tugasdaspro.databinding.ActivityLoopingBinding

class Looping : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityLoopingBinding? = null
    private var _tempResult = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoopingBinding.inflate(layoutInflater)
        intializeListener()
        setContentView(_binding!!.root)
    }

    private fun intializeListener() {
        _binding!!.results = ""
    }

    private fun process() {
        if (_binding!!.first.editText!!.text.toString().toInt() <  _binding!!.second.editText!!.text.toString().toInt()) {
            for (i in _binding!!.first.editText!!.text.toString().toInt() until   _binding!!.second.editText!!.text.toString().toInt() + 1) {
                _tempResult = "$_tempResult Looping ke $i \n"
            }
        } else {
            for (i in _binding!!.first.editText!!.text.toString().toInt() downTo  _binding!!.second.editText!!.text.toString().toInt()) {
                _tempResult = "$_tempResult Looping ke $i \n"
            }
        }
        _binding!!.results = _tempResult
    }

    private fun clear() {
        _binding!!.first.editText!!.setText("")
        _binding!!.second.editText!!.setText("")
        _tempResult = ""
        _binding!!.results = _tempResult
        sendBroadcast(Intent())
    }

    override fun onClick(v: View?) {
        if(v == _binding!!.process) {
            if (_binding!!.results!!.isEmpty()) {
                process()
            } else {
                _tempResult = ""
                process()
            }
        } else if (v == _binding!!.clearView){
            clear()
        }
    }
}