package com.example.bitcoinresponce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bitcoinresponce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel: MyViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        binding.button.setOnClickListener {
            viewModel.getData()
        }
        viewModel.uiState.observe(this){
            when(it){
                is MyViewModel.UIState.Empty -> Unit
                is MyViewModel.UIState.Result -> binding.textView.text = it.title
                is MyViewModel.UIState.Processing -> binding.textView.text = "Processing"
                is MyViewModel.UIState.Error -> binding.textView.text = it.description
            }

        }

    }
}