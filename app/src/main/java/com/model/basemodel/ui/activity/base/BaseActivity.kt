package com.model.basemodel.ui.activity.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import android.widget.TextView
import com.model.basemodel.R
import com.model.basemodel.util.setNotificationBarColor
import de.greenrobot.event.EventBus
import org.jetbrains.anko.AnkoLogger

/**
 * BaseModel
 * Created by wangchong on 2017/7/13.
 */
abstract class BaseActivity : IBase, AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        val toolbar = findViewById(R.id.toolbar) as? Toolbar
        toolbar?.setNavigationOnClickListener {
            onBack()
        }
        val toolbar_title = findViewById(R.id.toolbar_title) as? TextView
        toolbar_title?.text = title

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        setStatusBarColor(ContextCompat.getColor(this@BaseActivity, R.color.colorPrimary))
        initView()
        initData()
    }

    open fun onBack(){
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    abstract val title: String
    abstract val layoutResId: Int
    abstract override fun initView()
    abstract override fun initData()


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


    fun setStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
            val window = window
            //取消设置透明状态栏,使 ContentView 内容不再沉浸到状态栏下
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置状态栏颜色
            window.statusBarColor = color
        } else {
            setNotificationBarColor(color)
        }
    }


    override fun getResources(): Resources {
        val resources = super.getResources()
        val configuration = Configuration()
        configuration.setToDefaults()
        resources.updateConfiguration(configuration,
                resources.displayMetrics)
        return resources
    }


}
