package com.example.study.domain.usecase

import com.example.core_data.repo.TextRepository
import com.example.studymvi.model.Text
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TextListUseCase @Inject constructor(private val textRepository: TextRepository) {

    operator fun invoke(): Flow<List<Text>> =
        textRepository.textList
}