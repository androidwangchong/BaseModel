package com.model.basemodel

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.model.basemodel.http.RetrofitClient
import com.model.basemodel.http.api.DemoAPI
import com.model.basemodel.http.api.model
import com.model.basemodel.ui.adapter.HomePageFragmentAdapter
import org.androidannotations.annotations.res.StringArrayRes
import org.jetbrains.anko.find
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : FragmentActivity() {
    lateinit var tl_container: TabLayout
    lateinit var fl_container : FrameLayout
    lateinit var pageAdapter : HomePageFragmentAdapter
    val tabNames: Array<String> = arrayOf("信用","服务","我的")
    val tabIcons: IntArray = intArrayOf(R.drawable.selector_credit,R.drawable.selector_credit,R.drawable.selector_credit)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tl_container = find(R.id.tl_container)
        fl_container = find(R.id.fl_container)
        pageAdapter = HomePageFragmentAdapter(supportFragmentManager)

        for ( i in 0..tabNames.size) {
            val tabView = View.inflate(this, R.layout.tab_indicator, null)
             val textView = tabView.find<TextView>(R.id.tab_title)
            textView.text =(tabNames[i])
            // 利用这种办法设置图标是为了解决默认设置图标和文字出现的距离较大问题
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[i], 0, 0);
            tl_container.addTab(tl_container.newTab().setCustomView(textView));
        }
        // 初始化默认显示的fragment
        val fragment =  pageAdapter.instantiateItem(fl_container, 0) as Fragment
        pageAdapter.setPrimaryItem(fl_container, 0, fragment)
        pageAdapter.finishUpdate(fl_container)
        pageAdapter.destroyItem(fl_container, 0, fragment)

        // Tablayout选择tab监听
        tl_container.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tl_container.getSelectedTabPosition()
                val fragment = pageAdapter.instantiateItem(tl_container, position)
                pageAdapter.setPrimaryItem(tl_container, position, fragment)
                pageAdapter.finishUpdate(tl_container)
                pageAdapter.destroyItem(tl_container, position, fragment)
            }

        })


    }
}
