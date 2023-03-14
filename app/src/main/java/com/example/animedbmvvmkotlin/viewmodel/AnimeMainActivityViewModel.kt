package com.example.animedbmvvmkotlin.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedbmvvmkotlin.model.AnimeDbModel
import com.example.animedbmvvmkotlin.repository.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeMainActivityViewModel(private val repository: AnimeRepository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAnimes(1,10)
        }
    }
    val animeLive:LiveData<AnimeDbModel>
    get() = repository.animeAll

}