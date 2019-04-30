package com.model.basemodel

import com.model.basemodel.dslbuilder.ClickView
import com.model.basemodel.ui.activity.base.BaseActivity
import com.model.basemodel.dslbuilder.Toast
import com.model.basemodel.util.clickThrottleFirst
import kotlinx.android.synthetic.main.activity_main.*


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
        ClickView {
            view = rd_menu_mine
            todo = {
                Toast {
                    content = "123123"
                }
            }
        }

    }

    override fun initData() {
//        startActivity(intentFor<MainListActivity>())
    }
}