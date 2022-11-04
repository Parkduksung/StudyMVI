package com.example.core_network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestDebugInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("결과","Request : $request")
        val response = chain.proceed(request)
        Log.d("결과","Request : $response")
        return response
    }
}