package com.example.study.domain.usecase

import com.example.core_data.repo.TextRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TotalTextCountUseCase @Inject constructor(private val textRepository: TextRepository) {

    operator fun invoke(): Flow<Int> =
        textRepository.textList.map { it.size }
}