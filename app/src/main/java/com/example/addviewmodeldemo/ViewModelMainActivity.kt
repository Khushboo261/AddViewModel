package com.example.addviewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMainActivity(startingTotal : Int) : ViewModel() {
    //private var total =0
    private  var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
    get() = total
    init{
        total.value = startingTotal

    }

    fun setTotal(input:Int){
        total.value =(total.value)?.plus(input)
    }
}