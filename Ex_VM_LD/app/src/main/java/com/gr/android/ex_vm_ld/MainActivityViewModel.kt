package com.gr.android.ex_vm_ld

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String> = _name

    private val _otherInfo: MutableLiveData<String> = MutableLiveData()
    val otherInfo: LiveData<String> = _otherInfo

    fun updateName(thisName: String) {
        _name.value = thisName
    }

    fun updateOtherInfo(thisOtherInfo: String) {
        _otherInfo.value = thisOtherInfo
    }

    fun updateAgainOtherInfo() {
        _otherInfo.value = "${otherInfo.value} - 10"
    }
}