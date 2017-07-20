package com.model.basemodel

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.model.basemodel.http.RetrofitClient
import com.model.basemodel.http.api.DemoAPI
import com.model.basemodel.http.api.model
import com.orhanobut.logger.Logger
import com.yimai.app.ui.base.BaseListActivity
import net.idik.lib.slimadapter.SlimAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * BaseModel
 * Created by wangchong on 2017/7/17.
 */
class MainListActivity : BaseListActivity() {

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
        RetrofitClient.retrofit.create(DemoAPI::class.java).userInfo().enqueue(
                object : Callback<model> {
                    override fun onFailure(p0: Call<model>?, p1: Throwable?) {

                    }

                    override fun onResponse(p0: Call<model>?, p1: Response<model>?) {
                        Logger.json(p1?.body().toString())

                        for (i in 0..2) {
                            p1?.body()?.let { list.add(it) }
                        }
                        adapter.updateData(list).notifyDataSetChanged()
                        refreshComplete()
                    }
                }
        )
    }

    override fun onRefresh() {
        initData()
    }

    override fun onLoadMore() {
    }


}