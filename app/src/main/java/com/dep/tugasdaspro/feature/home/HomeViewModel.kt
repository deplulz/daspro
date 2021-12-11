package com.dep.tugasdaspro.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dep.tugasdaspro.feature.config.arrayMhs

class HomeViewModel : ViewModel() {

    private val _getMhsRegister = MutableLiveData<Int>().apply {
        value = arrayMhs.length()
    }


    val mhsRegister: LiveData<Int> = _getMhsRegister
}