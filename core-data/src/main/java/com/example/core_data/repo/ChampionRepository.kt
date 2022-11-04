package com.example.core_data.repo

import com.example.core_model.Champion
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {

   suspend fun getAllChampions(): Flow<List<Champion>>
}