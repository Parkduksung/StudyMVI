package com.example.studymvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.*

class SampleRepositoryImpl : SampleRepository {

    override fun getData(): Flow<String> =
        flowOf(Random().nextInt(100).toString())


    companion object {

        private var INSTANCE: SampleRepository? = null

        //singleton
        fun getInstance(): SampleRepository = INSTANCE ?: SampleRepositoryImpl().also {
            INSTANCE = it
        }
    }
}

//injection
object InjectRepository {
    fun provideSample(): SampleRepository =
        SampleRepositoryImpl.getInstance()
}
