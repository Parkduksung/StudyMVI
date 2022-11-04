package com.example.core_network

import com.example.core_model.Champion
import com.example.core_model.ChampionResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChampionService {

    @GET("data/en_US/champion.json")
    suspend fun fetchAllChampions(): Response<ChampionResponse<Champion>>
}