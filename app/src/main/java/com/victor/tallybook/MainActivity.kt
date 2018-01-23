package com.victor.tallybook

import android.os.Bundle
import android.view.View
import com.victor.common.kotlin.base.BaseActivity
import com.victor.common.kotlin.base.BasePresenter

class MainActivity<V, T : BasePresenter<V>> : BaseActivity<V, T>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onClick(v: View?) {
    }

    override fun initActivityView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
    }

    override fun createPresenter(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

