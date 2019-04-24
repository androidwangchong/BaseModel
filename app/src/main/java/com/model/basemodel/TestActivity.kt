package com.model.basemodel

import com.model.basemodel.ui.activity.base.BaseActivity
import org.jetbrains.anko.intentFor


/**
 * BaseModel
 * Created by wangchong on 2017/7/27.
 */
class TestActivity : BaseActivity() {
    override fun layoutResId(): Int {
        return R.layout.activity_main
    }

    override fun getIntentMessageData() {

    }

    override val title: String = "测试activity"

    override fun initView() {



    }

    override fun initData() {
        startActivity(intentFor<MainListActivity>())
    }
}