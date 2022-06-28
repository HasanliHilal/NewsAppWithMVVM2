package com.example.newsappwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.anushka.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import com.example.newsappwithmvvm.databinding.ActivityMainBinding
import com.example.newsappwithmvvm.presentation.adapter.NewsAdapter
import com.example.newsappwithmvvm.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter:NewsAdapter
    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bnvNews.setupWithNavController(
            navHostFragment.navController
        )
        viewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)
    }
}