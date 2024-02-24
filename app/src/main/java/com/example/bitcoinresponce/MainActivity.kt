package com.example.bitcoinresponce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bitcoinresponce.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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