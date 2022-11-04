package com.example.core_data.repo

import android.util.Log
import com.example.core_model.Champion
import com.example.core_network.ChampionService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChampionRepositoryImpl @Inject constructor(private val championService: ChampionService) :
    ChampionRepository {

    override suspend fun getAllChampions(): Flow<List<Champion>> = flow {
        Log.d("결과", "getAllChampions")
        emit(championService.fetchAllChampions().body()?.toList() ?: emptyList())
    }
}