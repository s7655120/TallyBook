package com.victor.common.kotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Fragment基类
 * Created by Victor on 2018/1/23.
 */
abstract class BaseFragment<V, T : BasePresenter<V>> : Fragment(){

    private val _STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"

    // 需要添加kotlin的反射库
    val TAG = javaClass.simpleName

    lateinit var mPresenter : T

    //定义一个View用来保存Fragment创建的时候使用打气筒工具进行的布局获取对象的存储
    lateinit var mView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean(_STATE_SAVE_IS_HIDDEN, isHidden())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = initFragmentView(inflater)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initFragmentChildView(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initFragmentData(savedInstanceState)
    }

    /**
     * 完成打气筒操作
     */
    protected abstract fun initFragmentView(inflater: LayoutInflater?): View

    /**
     * 进行findViewById的操作
     * @param view 打气筒生成的View对象
     */
    protected abstract fun initFragmentChildView(view : View?)

    /**
     * 数据填充的操作
     * @param savedInstanceState
     */
    protected abstract fun initFragmentData(savedInstanceState : Bundle?)

    /**
     * 创建Presenter对象
     */
    protected abstract fun createPresenter(): T

    override fun onResume() {
        super.onResume()
        if (null != mPresenter) {
            mPresenter.attachView(this as V)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (null != mPresenter) {
            mPresenter.detachView()
        }
    }

}