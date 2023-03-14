package com.example.animedbmvvmkotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animedbmvvmkotlin.repository.AnimeRepository

class AnimeMainActivityViewModelFactory(private val repository: AnimeRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AnimeMainActivityViewModel(repository) as T
    }
}