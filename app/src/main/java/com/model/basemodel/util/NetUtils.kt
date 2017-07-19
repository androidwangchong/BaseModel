package com.model.basemodel.util

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo


/**
 * 网络相关辅助类
 *
 * 创建时间： 2017/7/18.
 * 作者：WangZhuang
 * 功能描述：
 */
class NetUtils {
    /**
     * 判断网络是否连接

     * @param context
     * *
     * @return
     */
    fun isConnected(context: Context): Boolean {

        val connectivity: ConnectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (null != connectivity) {

            val info = connectivity.activeNetworkInfo
            if (null != info && info.isConnected) {
                if (info.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * 判断是否是wifi连接
     */
    fun isWifi(context: Context): Boolean {
        val cm = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager ?: return false

        return cm.activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI

    }

    /**
     * 打开网络设置界面
     */
    fun openSetting(activity: Activity) {
        val intent = Intent("/")
        val cm = ComponentName("com.android.settings",
                "com.android.settings.WirelessSettings")
        intent.component = cm
        intent.action = "android.intent.action.VIEW"
        activity.startActivityForResult(intent, 0)
    }
}