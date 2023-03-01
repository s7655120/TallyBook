package com.victor.common.kotlin.base

import java.lang.ref.Reference
import java.lang.ref.SoftReference

/**
 * Presenter 基类
 * Created by Victor on 2018/1/22.
 */
abstract class BasePresenter<T> {

    //View接口类型的软引用
    var mViewRef: Reference<T>? = null

    fun attachView(view: T) {
        //建立关系
        mViewRef = SoftReference<T>(view)
    }

    protected fun getView(): T? = mViewRef?.get()

    fun isViewAttached(): Boolean = mViewRef?.get() != null

    fun detachView() = mViewRef?.clear()

}