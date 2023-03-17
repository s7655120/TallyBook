//package com.victor.common.kotlin.base
//
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.view.View
//
///**
// * Activity 基类
// * Created by Victor on 2018/1/22.
// */
//abstract class BaseActivity<V, T : BasePresenter<V>> : AppCompatActivity(), View.OnClickListener {
//
//    // 需要添加kotlin的反射库
//    val TAG = javaClass.simpleName
//
//    lateinit var mPresenter : T
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initActivityView(savedInstanceState)
//        mPresenter = createPresenter()
//        mPresenter.attachView(this as V)
//
//        initView()
//        initData()
//    }
//
//    abstract fun initActivityView(savedInstanceState: Bundle?)
//
//    /**
//     * 创建Presenter 对象
//     * @return  T
//     */
//    abstract fun createPresenter() : T
//
//    /**
//     * 加载页面元素
//     */
//    abstract fun initView()
//
//    /**
//     * 加载页面数据
//     */
//    abstract fun initData()
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter?.detachView()
//    }
//}