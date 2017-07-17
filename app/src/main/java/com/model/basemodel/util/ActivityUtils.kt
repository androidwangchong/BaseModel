package com.model.basemodel.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout

/**
 * yimai_android
 * Created by wangchong on 2017/6/17.
 */
/**
 * 设置状态栏颜色
 * @param color    状态栏颜色值
 */
fun Activity.setNotificationBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // 设置状态栏透明
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        // 生成一个状态栏大小的矩形
        val statusView = createStatusView(color)
        // 添加 statusView 到布局中
        val decorView = window.decorView as ViewGroup
        decorView.addView(statusView)
        // 设置根布局的参数
        val rootView = (findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
        rootView.fitsSystemWindows = true
        rootView.clipToPadding = true
    }
}

/**
 * 生成一个和状态栏大小相同的矩形条
 * *
 * @param color    状态栏颜色值
 * *
 * @return 状态栏矩形条
 */
fun Activity.createStatusView(color: Int): View {
    // 获得状态栏高度
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    val statusBarHeight = resources.getDimensionPixelSize(resourceId)

    // 绘制一个和状态栏一样高的矩形
    val statusView = View(this)
    val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            statusBarHeight)
    statusView.layoutParams = params
    statusView.setBackgroundColor(color)
    return statusView
}


//判断当前的应用程序是不是在运行
//需要申请GETTask权限
fun Activity.isApplicationBroughtToBackground(): Boolean {
    val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val tasks = am.getRunningTasks(1)
    if (!tasks.isEmpty()) {
        val topActivity = tasks[0].topActivity
        if (topActivity.packageName != packageName) {
            return true
        }
    }
    return false
}
