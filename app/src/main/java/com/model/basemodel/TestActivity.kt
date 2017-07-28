package com.model.basemodel

import com.model.basemodel.ui.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import com.model.basemodel.util.openLoginActivity


/**
 * BaseModel
 * Created by wangchong on 2017/7/27.
 */
class TestActivity : BaseActivity() {
    override val title: String = "测试activity"
    override val layoutResId: Int = R.layout.activity_main

    override fun initView() {
        text.onClick {
            openLoginActivity()
        }


    }

    override fun initData() {
    }
}