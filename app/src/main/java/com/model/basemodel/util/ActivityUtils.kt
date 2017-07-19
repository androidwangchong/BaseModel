package com.model.basemodel.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout


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
