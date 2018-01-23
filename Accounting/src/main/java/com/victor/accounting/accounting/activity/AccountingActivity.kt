package com.victor.accounting.accounting.activity

import android.os.Bundle
import android.view.View
import com.victor.accounting.R
import com.victor.common.kotlin.base.BaseActivity

/**
 * 记账界面
 * Created by Victor on 2018/1/23.
 */
class AccountingActivity : BaseActivity<AccountingContract.AccountingView, AccountingPresenter>() {

    override fun initActivityView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_accounting)
    }

    override fun onClick(v: View?) {

    }

    override fun createPresenter(): AccountingPresenter {
        return AccountingPresenter()
    }

    override fun initView() {

    }

    override fun initData() {

    }
}