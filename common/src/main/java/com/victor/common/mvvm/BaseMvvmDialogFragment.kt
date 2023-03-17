package com.victor.common.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding

abstract class BaseMvvmDialogFragment<T: ViewBinding>: DialogFragment(), View.OnClickListener {

    protected open lateinit var mBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = getViewBinding()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initView()
        initData()
        initListener()
    }

    abstract fun getViewBinding(): T

    abstract fun initView()
    abstract fun initData()
    abstract fun initListener()

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
    }

    override fun show(manager: FragmentManager, tag: String?) {
        val ft = manager.beginTransaction()
        ft.add(this, tag)
        ft.commitAllowingStateLoss()
    }

    override fun dismiss() {
        super.dismissAllowingStateLoss()
    }

    interface DisMissCallBack{
        fun onDismiss()
    }

    interface BtnClickCallBack{
        fun onClickCancel()
        fun onClickConfirm()
    }
}