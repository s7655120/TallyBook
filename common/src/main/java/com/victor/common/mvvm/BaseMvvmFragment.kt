package com.victor.common.mvvm

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
//import com.hcb.base.common.view.dialog.BaseCommonLoadingDialogFragment

abstract class BaseMvvmFragment<T: ViewBinding>: Fragment(), View.OnClickListener {

    protected open lateinit var mBinding: T
//    private lateinit var mLoadingDialog: BaseCommonLoadingDialogFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = getViewBinding()
        init()
        return mBinding.root
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

    private fun initLoadingDialogFragment(){
        val bundle = Bundle()
        bundle.putString("tip", "小宝正在加载中...")
//        mLoadingDialog = BaseCommonLoadingDialogFragment.newInstance(bundle)
//        mLoadingDialog.isCancelable = false
//        mLoadingDialog.arguments = bundle
    }

    open fun showLoading(message: String) {
//        if (!::mLoadingDialog.isInitialized) {
//            initLoadingDialogFragment()
//        }
//        if (mLoadingDialog.isAdded) {
//            return
//        }
//        if (!TextUtils.isEmpty(message)) {
//            var bundle = mLoadingDialog.arguments
//            if (bundle == null) {
//                bundle = Bundle()
//            }
//            bundle.putString("tip", message)
//            mLoadingDialog.arguments = bundle
//        }
//        mLoadingDialog.show(childFragmentManager, "loading")
    }

    open fun hideLoading() {
//        if (::mLoadingDialog.isInitialized) {
//            if (mLoadingDialog.isAdded) {
//                mLoadingDialog.dismissAllowingStateLoss()
//            }
//        }
    }
}