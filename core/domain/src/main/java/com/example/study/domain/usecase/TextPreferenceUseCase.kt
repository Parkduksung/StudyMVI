package com.example.study.domain.usecase

import com.example.core_data.repo.TextRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TextPreferenceUseCase @Inject constructor(private val textRepository: TextRepository) {

    operator fun invoke(): Flow<String> =
        textRepository.testTextPreferences
}