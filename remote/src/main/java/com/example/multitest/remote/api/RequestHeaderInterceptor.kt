package com.example.multitest.remote.api

import com.example.multitest.remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class RequestHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = try {
            chain.request().newBuilder()
                .apply {
                    addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
                }.build()
        } catch (e: Exception) {
            //todo handle error
            chain.request()
        }
        return chain.proceed(newRequest)
    }
}