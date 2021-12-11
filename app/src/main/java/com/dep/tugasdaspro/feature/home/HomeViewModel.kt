package com.dep.tugasdaspro.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dep.tugasdaspro.feature.config.arrayMhs
import com.dep.tugasdaspro.feature.config.arrayMhsApproved

class HomeViewModel : ViewModel() {

    private val _getMhsRegister = MutableLiveData<Int>().apply {
        value = arrayMhs.length()
    }

    private val _getMhsApproved = MutableLiveData<Int>().apply {
        value = arrayMhsApproved.length()
    }



    val mhsRegister: LiveData<Int> = _getMhsRegister
    val mhsApproved: LiveData<Int> = _getMhsApproved
}