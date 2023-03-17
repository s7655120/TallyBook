package com.victor.core.network

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class HttpResponseAdapter(
    private val successType: Type,
    private val errorHandler: ErrorHandler?
) : CallAdapter<Any, Call<Any>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<Any>): Call<Any> =
        HttpResponseCall(call, successType as ParameterizedType, errorHandler)
}
