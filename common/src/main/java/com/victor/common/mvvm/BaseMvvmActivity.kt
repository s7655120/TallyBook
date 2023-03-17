package com.victor.common.mvvm

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding

abstract class BaseMvvmActivity<T: ViewBinding>: AppCompatActivity(), View.OnClickListener {
    protected open lateinit var mBinding: T

//    private var titleBinding: BaseCommonCompatTitleBinding? = null
//
//    private lateinit var mLoadingDialog: BaseCommonLoadingDialogFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getViewBinding()
        setContentView(mBinding.root)

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

//    fun setCommonTitleBinding(titleBinding: BaseCommonCompatTitleBinding?){
//        this.titleBinding = titleBinding
//    }
//
//    protected fun setCommonTitle(title: String? = null, @ColorRes colorRes: Int = R.color.hcb_custom_color_333333, isShow: Boolean = false){
//        titleBinding?.let {
//            it.tvBaseCommonTitle.text = if (!TextUtils.isEmpty(title)){
//                 title
//            } else {
//                getTitle() ?: ""
//            }
//
//            it.tvBaseCommonTitle.setTextColor(ContextCompat.getColor(this, colorRes))
//
//            it.tvBaseCommonTitle.visibility = if (isShow){
//                View.VISIBLE
//            } else {
//                View.GONE
//            }
//        }
//
//    }

    /** 设置返回事件 */
    protected fun setCommonBack(@DrawableRes icon: Int = 0, @ColorInt color: Int = Color.TRANSPARENT) {
//        titleBinding?.let {
//            it.ivBaseCommonBack.apply {
//                setOnClickListener(this@BaseMvvmActivity)
//                if (icon != 0){
//                    setImageResource(icon)
//                }
//                if (color != Color.TRANSPARENT){
//                    setColorFilter(color)
//                }
//            }
//        }
    }

    /** 设置网页关闭事件 */
    protected fun setCommonWebClose() {
//        titleBinding?.let {
//            it.ivBaseCommonWebClose.visibility = View.VISIBLE
//            it.ivBaseCommonWebClose.setOnClickListener(this)
//        }
    }

    /**
     * 设置提示
     * @param contentId 提示内容id
     */
    protected fun setCommonTips(@StringRes contentId: Int = 0, content: String? = null,
                                isShow: Boolean = false,  isEnable: Boolean = true,
                                @ColorRes colorResId: Int = 0) {

//        titleBinding?.let {
//            it.tvBaseCommonTips.apply {
//                visibility = View.VISIBLE
//                setOnClickListener(this@BaseMvvmActivity)
//                if (!TextUtils.isEmpty(content)){
//                    text = content
//                } else {
//                    setText(contentId)
//                }
//                isEnabled = isEnable
//                visibility = if (isShow){
//                    View.VISIBLE
//                } else {
//                    View.GONE
//                }
//                setTextColor(ContextCompat.getColor(this@BaseMvvmActivity, colorResId))
//            }
//        }
    }

    protected fun setCompatTitleBgColor(@ColorInt colorInt: Int) {
//        titleBinding?.rlBaseCommonCompatTitle?.setBackgroundColor(colorInt)
    }

    /**
     * 显示通用状态栏
     */
    protected fun showCommonStatusBar(@ColorInt color: Int, isBgDarkColor: Boolean) {
//        StatusBarUtil.showStatusBarBgWithDarkColor(window, isBgDarkColor, false);
//        titleBinding?.apply {
//            baseCommonStatusBar.setBackgroundColor(color)
//            baseCommonStatusBar.visibility = View.VISIBLE
//            baseCommonStatusBar.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getStatusHeight(this@BaseMvvmActivity))
//        }
    }

    override fun onClick(v: View) {
//        titleBinding?.apply {
//            when (v) {
//                ivBaseCommonBack -> onBackPressed()
//                ivBaseCommonWebClose -> finish()
//                tvBaseCommonTips -> clickCommonTips()
//            }
//        }
    }

    private fun initLoadingDialogFragment(){
//        val bundle = Bundle()
//        bundle.putString("tip", "小宝正在加载中...")
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
//        mLoadingDialog.show(supportFragmentManager, "loading")
    }

    open fun hideLoading() {
//        if (::mLoadingDialog.isInitialized) {
//            if (mLoadingDialog.isAdded) {
//                mLoadingDialog.dismissAllowingStateLoss()
//            }
//        }
    }

    open fun clickCommonTips(){}

}