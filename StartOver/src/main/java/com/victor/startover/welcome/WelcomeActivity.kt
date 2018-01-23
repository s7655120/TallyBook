package com.victor.startover.welcome

import android.os.Bundle
import android.view.View
import com.victor.common.kotlin.base.BaseActivity
import com.victor.startover.R

/**
 * 欢迎界面
 * Created by Victor on 2018/1/22.
 */
class WelcomeActivity : BaseActivity<WelcomeContract.WelcomeView, WelcomePresenter>(){

    override fun initActivityView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_welcome)
    }

    override fun createPresenter(): WelcomePresenter {
        return WelcomePresenter()
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onClick(v: View?) {
    }
}