package com.model.basemodel

import com.model.basemodel.ui.activity.base.BaseActivity
import com.model.basemodel.ui.widget.Toaster
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * BaseModel
 * Created by wangchong on 2017/7/27.
 */
class TestActivity : BaseActivity() {
    override val title: String = "测试activity"
    override val layoutResId: Int = R.layout.activity_main

    override fun initView() {
        text.onClick {
            showProgressBarDialog("正在设置。。。。。。。")
        }


    }

    override fun initData() {
    }
}