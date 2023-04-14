package com.example.studymvi.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .catch { emit(Result.Error(it)) }
}


fun <T, P> (suspend (P) -> Response<T>).toResultFlowWithParam(): (P) -> Flow<Result<T>> {
    return { param: P ->
        flow {
            emit(this@toResultFlowWithParam(param).toResult())
        }.catch { throwable ->
            //Exception Manager
        }
    }
}

fun <T, P1, P2> (suspend (P1, P2) -> Response<T>).toResultFlowWithParam(): (P1, P2) -> Flow<Result<T>> {
    return { p1, p2 ->
        flow {
            emit(this@toResultFlowWithParam(p1, p2).toResult())
        }.catch { throwable ->
            //Exception Manager
        }
    }
}

fun <T, P1, P2, P3> (suspend (P1, P2, P3) -> Response<T>).toResultFlowWithParam(): (P1, P2, P3) -> Flow<Result<T>> {
    return { p1, p2, p3 ->
        flow {
            emit(this@toResultFlowWithParam(p1, p2, p3).toResult())
        }.catch { throwable ->
            //Exception Manager
        }
    }
}


fun <T> (suspend () -> Response<T>).toResultFlow(): Flow<Result<T>> {
    return flow {
        emit(this@toResultFlow().toResult())
    }.catch { throwable ->
        //Exception Manager
    }
}

fun <T> Response<T>.toResult(): Result<T> {
    return if (isSuccessful) {
        val body = body()
        if (body != null) {
            Result.Success(body)
        } else {
            //body null
            Result.Error()
        }
    } else {
        //company custom exception
        Result.Error()
    }
}
