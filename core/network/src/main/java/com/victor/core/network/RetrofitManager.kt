package com.victor.core.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

object RetrofitManager {

    private const val BASE_URL = "http://app.test.hcbkeji.com"

    /** 默认请求时间 20s */
    private const val CONNECT_TIME_OUT_SECONDS = 20

    private const val WRITE_TIME_OUT_SECONDS = 60

//    private lateinit var cookieJarImpl: UserCookieJarImpl


    /** OkHttpClient相关配置 */
    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(
//                if (HcbApp.isLogin){
//                    HttpPublicParamsInterceptor()
//                } else {
                    HttpNoLoginPublicParamsInterceptor()
//                }
            )

//            .cookieJar(cookieJarImpl)
            .connectTimeout(CONNECT_TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .readTimeout(WRITE_TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .build()

    private val servicesMap = ConcurrentHashMap<String, BaseService>()
//    private val errorHandlers = mutableListOf<ErrorHandler>()
//
//    fun init(cookieJar: UserCookieJarImpl) {
//        cookieJarImpl = cookieJar
//        addErrorHandlerListener(ErrorToastHandler)
//    }
//
//    fun addErrorHandlerListener(handler: ErrorHandler) {
//        errorHandlers.add(handler)
//    }

    /**
     * Todo(Inject Implementation)
     */
    @Suppress("UNCHECKED_CAST")
    fun <T : BaseService> getService(serviceClass: Class<T>, baseUrl: String? = null): T {
        return servicesMap.getOrPut(serviceClass.name) {
            Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(HttpResponseAdapterFactory(object : ErrorHandler {
                    override fun bizError(code: Int, msg: String) {
//                        ApplicationCoroutineScope.provideApplicationScope()
//                            .launch(CoroutinesModule.providesMainImmediateDispatcher()) {
//                                errorHandlers.forEach { it.bizError(code, msg) }
//                            }
//                        AppLog.d(msg = "bizError: code:$code - msg: $msg")
                        Log.e("test", "bizError: code:$code - msg: $msg")
                    }

                    override fun otherError(throwable: Throwable) {
//                        ApplicationCoroutineScope.provideApplicationScope()
//                            .launch(CoroutinesModule.providesMainImmediateDispatcher()) {
//                                errorHandlers.forEach { it.otherError(throwable) }
//                            }
//                        AppLog.e(msg = throwable.message.toString(), throwable = throwable)
                        Log.e("test otherError",  throwable.message.toString())
                    }
                }))
                .addConverterFactory(GsonConverterFactory.create())

                .baseUrl(baseUrl ?: BASE_URL)
                .build()
                .create(serviceClass)
        } as T
    }

}