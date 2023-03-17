package com.victor.core.network

import com.google.gson.annotations.SerializedName

open class HttpResponse<out T: Any> {

    /**
     * 其他错误
     */
    data class UnknownError(val throwable: Throwable) : HttpResponse<Any>()

    /** 请求成功的code码  */
    private val successCode = 200

    /** 其他类型成功的code码  */
    private val successOtherTypeCode = 201

    /** 其他行为导致的结果和成功一致的状态码  */
    private val successOtherActionTypeCode = 202

    /** 系统错误的code码  */
    private val systemErrorCode = 10000

    /*
     * code : 200
     * msg : 获取成功
     * data : {}
     */
    /** 请求返回值  */
    @SerializedName("code")
    val responseCode = 0

    /** -200条件下部分接口用到， 0：表示正常  1：加油站、货车专修查询超过次数  */
    @SerializedName("flag")
    val status = 0

    /** 请求返回提示  */
    @SerializedName("msg")
    val responseMsg: String = ""

    /** 请求返回的bean数据  */
    @SerializedName("data")
    val responseData: T? = null

    val isSuccessful: Boolean
        get() {
            return successCode == responseCode
        }

    val isOtherTypeSuccessful: Boolean
        get() {
            return successOtherTypeCode == responseCode
        }

    val HttpResponse<*>.isOtherActionSuccessful: Boolean
        get() {
            return successOtherActionTypeCode == responseCode
        }

    fun isSystemError(): Boolean {
        return systemErrorCode == responseCode
    }

//    fun <T : Any> HttpResponse<T>.getOrError(): T? =
//        when (this) {
//            is HttpResponse.Success -> data
//            is HttpResponse.BizError -> null
//            is HttpResponse.UnknownError -> null
//        }

    override fun toString(): String {
        return responseMsg.toString()
    }

}