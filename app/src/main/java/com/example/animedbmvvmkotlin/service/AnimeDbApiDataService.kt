package com.example.animedbmvvmkotlin.service

import com.example.animedbmvvmkotlin.model.AnimeDbModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimeDbApiDataService {

    @Headers(
        "X-RapidAPI-Key:dc0574d5c4msh4bc3b5e267988d4p1cbc6fjsna6896bb699b0",
        "X-RapidAPI-Host:anime-db.p.rapidapi.com")
    @GET("anime")
   suspend fun getAllAnime(@Query("page") page:Int, @Query("size")size:Int): Response<AnimeDbModel>
}