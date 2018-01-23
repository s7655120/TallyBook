package com.victor.accounting.accounting

import android.os.Bundle
import android.view.View
import com.victor.common.kotlin.base.BaseActivity

/**
 * 记账界面
 * Created by Victor on 2018/1/23.
 */
class AccountingActivity : BaseActivity<AccountingContract.AccountingView, AccountingPresenter>() {

    override fun initActivityView(savedInstanceState: Bundle?) {

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