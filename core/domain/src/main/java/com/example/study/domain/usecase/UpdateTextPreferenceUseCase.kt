package com.example.study.domain.usecase

import com.example.core_data.repo.TextRepository
import com.example.studymvi.model.Text
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateTextPreferenceUseCase @Inject constructor(private val textRepository: TextRepository) {

    operator fun invoke(text: Text): Flow<Unit> = flow {
        emit(textRepository.updateTestString(text.text))
    }
}