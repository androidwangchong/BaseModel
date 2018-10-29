package com.model.basemodel

import com.model.basemodel.ui.activity.base.BaseActivity


/**
 * BaseModel
 * Created by wangchong on 2017/7/27.
 */
class TestActivity : BaseActivity() {
    override fun getIntentMessageData() {

    }

    override val title: String = "测试activity"
    override val layoutResId: Int = R.layout.activity_main

    override fun initView() {



    }

    override fun initData() {
    }
}