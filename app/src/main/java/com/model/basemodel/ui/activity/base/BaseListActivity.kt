package com.yimai.app.ui.base

import `in`.srain.cube.views.ptr.PtrClassicFrameLayout
import `in`.srain.cube.views.ptr.PtrDefaultHandler2
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.header.StoreHouseHeader
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.jaeger.library.StatusBarUtil
import com.model.basemodel.R
import com.model.basemodel.ui.activity.base.IBase
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import de.greenrobot.event.EventBus
import kotlinx.android.synthetic.main.common_list.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.dip
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * BaseModel
 * Created by wangchong on 2017/7/13.
 */
abstract class BaseListActivity : IBase, AppCompatActivity(), AnkoLogger {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initToolBar()
        initListViewFrame()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        StatusBarUtil.setColor(this@BaseListActivity, ContextCompat.getColor(this@BaseListActivity, R.color.colorPrimary))
        getIntentMessageData()
        initView()
        initData()
        initErrorLayout()
    }

    fun initToolBar() {
        val toolbar = findViewById(R.id.toolbar) as? Toolbar
        toolbar?.setNavigationOnClickListener {
            finish()
        }
        val toolbar_title = findViewById(R.id.toolbar_title) as? TextView
        toolbar_title?.text = title
    }

    var mRefreshLayout: SmartRefreshLayout? = null
    var mRecyclerView: RecyclerView? = null

    fun initListViewFrame() {
        mRecyclerView = findViewById(R.id.recyler_view)
                as RecyclerView
        mRecyclerView?.apply {
            layoutManager = LinearLayoutManager(this@BaseListActivity, LinearLayoutManager.VERTICAL, false)
        }
        mRefreshLayout = findViewById(R.id.refreshLayout)
                as SmartRefreshLayout
        mRefreshLayout?.setOnRefreshListener { refreshLayout ->
            refreshLayout.layout.postDelayed({
                onRefresh()
                hideErrorLayout()
                refreshLayout.finishRefresh()
                refreshLayout.resetNoMoreData()//刷新时重制loadmore
            }, 2000)
        }
        mRefreshLayout?.setOnLoadMoreListener { refreshLayout ->
            refreshLayout.layout.postDelayed({
                onLoadMore()
                refreshLayout.finishLoadMore()
//                refreshLayout.finishLoadMoreWithNoMoreData()//将不会再次触发加载更多事件
            }, 2000)
        }
        //触发自动刷新
//        refreshLayout.autoRefresh()
    }

    //停止刷新
    fun refreshComplete() {
        mRefreshLayout?.finishRefresh()
    }

    //设置网络错误时，点击重新请求
    fun initErrorLayout() {
        error_layout.onClick {
            onRefresh()
        }
    }

    abstract val title: String
    abstract val layoutResId: Int
    abstract fun getIntentMessageData()
    abstract override fun initView()
    abstract override fun initData()
    abstract fun onRefresh()
    abstract fun onLoadMore()

    open fun onEvent(event: Any) {

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    fun showErrorLayout() {
        error_layout.visibility = View.VISIBLE
    }

    fun hideErrorLayout() {
        error_layout.visibility = View.GONE
    }

    //    getString(R.string.Do_not_open_the_lottery)
    fun resultListIsEmpty(size: Int, content: String = getString(R.string.no_data)) {
        if (size == 0) {
            showEmptylayout(content)
        } else {
            hideEmptylayout()
        }
    }


    fun showEmptylayout(content: String) {
        empty_layout.visibility = View.VISIBLE
        content_text.text = content
    }

    fun hideEmptylayout() {
        empty_layout.visibility = View.GONE
    }


}
