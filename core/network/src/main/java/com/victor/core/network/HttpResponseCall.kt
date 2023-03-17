package com.victor.core.network

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.reflect.ParameterizedType

internal class HttpResponseCall(
    private val delegate: Call<Any>,
    private val wrapperType: ParameterizedType,
    private val errorHandler: ErrorHandler?
) : Call<Any> {

    override fun enqueue(callback: Callback<Any>): Unit =
        delegate.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                // 无论请求响应成功还是失败都回调 Response.success
                if (response.isSuccessful) {
                    val body = response.body()

                    val httpResponse = body as HttpResponse<*>

                    if (!httpResponse.isSuccessful) {
                        errorHandler?.bizError(httpResponse.responseCode, httpResponse.responseMsg)
                    }
                    callback.onResponse(this@HttpResponseCall, Response.success(body))
                } else {
                    val exception = HttpException(response)
                    errorHandler?.otherError(exception)
                    callback.onResponse(
                        this@HttpResponseCall,
                        Response.success(HttpResponse.UnknownError(exception))
                    )
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                if (call.isCanceled) {
                    // 忽略请求被Canceled的情况
                    return
                }
                errorHandler?.otherError(t)
                callback.onResponse(
                    this@HttpResponseCall,
                    Response.success(HttpResponse.UnknownError(t))
                )
            }
        })

    override fun clone(): Call<Any> =
        HttpResponseCall(delegate, wrapperType, errorHandler)

    override fun execute(): Response<Any> =
        throw UnsupportedOperationException("${this.javaClass.name} doesn't support execute")

    override fun isExecuted(): Boolean = delegate.isExecuted
    override fun cancel(): Unit = delegate.cancel()
    override fun isCanceled(): Boolean = delegate.isCanceled
    override fun request(): Request = delegate.request()
    override fun timeout(): Timeout = delegate.timeout()

}
