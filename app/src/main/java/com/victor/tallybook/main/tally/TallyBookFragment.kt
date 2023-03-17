package com.victor.tallybook.main.tally

import android.view.LayoutInflater
import com.victor.common.mvvm.BaseMvvmFragment
import com.victor.common.utils.SpannableStringUtils
import com.victor.tallybook.R
import com.victor.tallybook.databinding.TallyBookFragmentBinding

class TallyBookFragment: BaseMvvmFragment<TallyBookFragmentBinding>() {

    override fun getViewBinding(): TallyBookFragmentBinding {
        return TallyBookFragmentBinding.inflate(LayoutInflater.from(context))
    }

    override fun initView() {
    }

    override fun initData() {
        SpannableStringUtils.getBuilder("0.").setProportion(1.5f).append("00").setProportion(0.8f).into(mBinding.tvTallyBookIncome)
        SpannableStringUtils.getBuilder("0.").setProportion(1.5f).append("00").setProportion(0.8f).into(mBinding.tvTallyBookPayment)
        mBinding.tvTallyBookYear.text = "2023年"
        SpannableStringUtils.getBuilder("03").setProportion(1.5f).append("月").setProportion(0.8f).into(mBinding.tvTallyBookMonth)
    }

    override fun initListener() {
        mBinding.apply {
            llTallyBookIncome.setOnClickListener(this@TallyBookFragment)
            llTallyBookPayment.setOnClickListener(this@TallyBookFragment)
        }
    }
}