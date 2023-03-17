package com.victor.tallybook.main

import android.view.LayoutInflater
import com.victor.common.mvvm.BaseMvvmActivity
import com.victor.tallybook.R
import com.victor.tallybook.databinding.MainActivityBinding
import com.victor.tallybook.main.tally.TallyBookFragment

class MainActivity : BaseMvvmActivity<MainActivityBinding>() {

    private lateinit var mTallyBookFragment: TallyBookFragment

    override fun getViewBinding(): MainActivityBinding {
        return MainActivityBinding.inflate(LayoutInflater.from(this))
    }

    override fun initView() {
        mTallyBookFragment = TallyBookFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl, mTallyBookFragment).commitAllowingStateLoss()
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}

