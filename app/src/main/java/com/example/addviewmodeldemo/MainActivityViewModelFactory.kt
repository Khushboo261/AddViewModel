package com.example.addviewmodeldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val startingTotal : Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewModelMainActivity::class.java)){
            return ViewModelMainActivity(startingTotal) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}