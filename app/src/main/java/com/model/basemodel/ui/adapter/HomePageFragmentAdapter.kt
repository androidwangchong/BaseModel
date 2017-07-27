package com.model.basemodel.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.model.basemodel.ui.activity.credit.CreditFragment
import com.model.basemodel.ui.activity.creditService.CreditServiceFragment
import com.model.basemodel.ui.activity.mine.MineFragment

/**
 * 首页tab页面切换适配器
 * 创建时间： 2017/7/27.
 * 作者：WangZhuang
 * 功能描述：
 */
class HomePageFragmentAdapter(val manager: FragmentManager) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> CreditFragment()
            1 -> CreditServiceFragment()
            else
            -> MineFragment()
        }
        return CreditFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}