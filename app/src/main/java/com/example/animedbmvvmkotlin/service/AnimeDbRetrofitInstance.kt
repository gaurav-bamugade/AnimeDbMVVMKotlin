package com.example.animedbmvvmkotlin.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AnimeDbRetrofitInstance {
    private val BASE_URL="https://anime-db.p.rapidapi.com/"

    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}