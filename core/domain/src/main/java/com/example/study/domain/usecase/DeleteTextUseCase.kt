package com.example.study.domain.usecase

import com.example.core_data.repo.TextRepository
import com.example.studymvi.model.Text
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteTextUseCase @Inject constructor(private val textRepository: TextRepository) {

    operator fun invoke(text: Text): Flow<Boolean> = flow {
        emit(textRepository.deleteTextItem(text) > 0)
    }
}