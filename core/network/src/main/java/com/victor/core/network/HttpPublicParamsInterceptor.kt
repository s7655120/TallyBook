//package com.victor.core.network
//
//import okhttp3.Interceptor
//import okhttp3.Response
//
//class HttpPublicParamsInterceptor: Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val version = "1931"
//        val platform = 0
//
//        val authToken = HcbApp.loginUserData.auth_token
//
//        var token : String = ""
//        var authTime : String = ""
//        var key = ""
//
//        authToken?.let {
//            token = it.token.toString()
//            authTime = System.currentTimeMillis().toString()
//            key = SecurityUtils.getKeyMd5(token + authTime)
//        }
//
//        var phone = HcbApp.loginUserData.Phone
//        val original = chain.request()
//        val request = original.newBuilder() //                .addHeader("phone", phone)
//            .addHeader("key", key)
//            .addHeader("ver", version) //                .addHeader("uid", String.valueOf(uid))
//            .addHeader("platform", platform.toString())
//            .addHeader("authtm", authTime)
//            .addHeader("devid", "AtfUMZ-pWbxzgAJCoiprrQwLL04KsRyuxdW_3CpYHDlx")
//            .addHeader("authtoken", token)
//            .addHeader("channel", "tencent")
//            .build()
//
//        return chain.proceed(request)
//
//    }
//}