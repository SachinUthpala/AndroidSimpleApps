package com.example.intentsviewmodeltutorial07

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityData:ViewModel() {
    private val _Count = MutableLiveData<Int>().apply { value = 0 }

    val count:LiveData<Int> = _Count

    fun increment(){
        _Count.value = _Count.value!! +1
    }
}