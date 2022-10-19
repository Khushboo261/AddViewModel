package com.example.addviewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.addviewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : ViewModelMainActivity
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelMainActivity::class.java)

        viewModel.totalData.observe(this, Observer {
            binding.tvNumber.text = it.toString()
        })

        binding.apply {
            btnAdd.setOnClickListener {
                viewModel.setTotal(number.text.toString().toInt())
                number.setText("")
            }
        }

    }
}