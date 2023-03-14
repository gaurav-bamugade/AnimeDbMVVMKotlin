package com.example.animedbmvvmkotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animedbmvvmkotlin.model.AnimeDbModel
import com.example.animedbmvvmkotlin.service.AnimeDbApiDataService

class AnimeRepository(private val animeDbApiDataService: AnimeDbApiDataService) {
    private val animeAllLiveData=MutableLiveData<AnimeDbModel>()

    val animeAll:LiveData<AnimeDbModel>
    get()=animeAllLiveData

    suspend fun getAnimes(page:Int,size:Int)
    {
        val result = animeDbApiDataService.getAllAnime(page,size)
        if(result.body() !=null)
        {
            animeAllLiveData.postValue(result.body())
        }
    }
}