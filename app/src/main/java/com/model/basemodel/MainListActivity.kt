package com.model.basemodel

import android.widget.ImageView
import com.alibaba.fastjson.JSON
import com.bumptech.glide.Glide
import com.model.basemodel.http.apiconfig.model
import com.model.basemodel.http.demoApi.userInfo
import com.orhanobut.logger.Logger
import com.yimai.app.ui.base.BaseListActivity
import net.idik.lib.slimadapter.SlimAdapter

/**
 * BaseModel
 * Created by wangchong on 2017/7/17.
 */
class MainListActivity : BaseListActivity() {
    override fun getIntentMessageData() {
    }

    private val adapter by lazy {
        SlimAdapter.create().register<model>(R.layout.view_demo) {
            data, injector ->
            injector.text(R.id.textView, data.title)
            val image = injector.findViewById<ImageView>(R.id.image) as ImageView
            Glide.with(this@MainListActivity).asGif()
                    .load(data.logo).into(image)
        }.attachTo(mRecyclerView)
    }
    val list = mutableListOf<Any>()
    override val title: String by lazy {
        "列表"
    }
    override val layoutResId: Int = R.layout.common_list

    override fun initView() {
    }

    override fun initData() {
        userInfo()
    }

    override fun onRefresh() {
        initData()
    }

    override fun onLoadMore() {
    }

    override fun onEvent(event: Any) {
        super.onEvent(event)
        when(event){
            is model -> {
                Logger.json(JSON.toJSONString(event))

                for (i in 0..2) {
                    event.let { list.add(it) }
                }
                adapter.updateData(list).notifyDataSetChanged()
                refreshComplete()
            }
        }
    }


}