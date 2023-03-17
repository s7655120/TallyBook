package com.victor.core.network

import okhttp3.Interceptor
import okhttp3.Response

class HttpNoLoginPublicParamsInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val version = "111"
        val platform = 0

        val original = chain.request()
        val request = original.newBuilder()
            .addHeader("ver", version)
            .addHeader("platform", platform.toString())
            .addHeader("channel", "tencent")
            .build()

        return chain.proceed(request)

    }
}