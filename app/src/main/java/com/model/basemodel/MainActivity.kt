package com.model.basemodel

import com.model.basemodel.ui.activity.base.BaseActivity

/**
 * 主Activity
 */
class MainActivity : BaseActivity() {
    override fun layoutResId(): Int {
        return R.layout.activity_main
    }


    override val title: String by lazy {
        ""
    }

    override fun getIntentMessageData() {
    }

    override fun initView() {
    }

    override fun initData() {
    }


}