package com.model.basemodel.util

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.AnimRes
import android.util.ArrayMap
import java.util.HashMap

/**
 * 创建时间： 2017/7/18.
 * 作者：WangZhuang
 * 功能描述：
 */
object ActivityUtil {
    /**
     * 判断是否存在Activity

     * @param packageName 包名
     * *
     * @param className   activity全路径类名
     * *
     * @return `true`: 是<br></br>`false`: 否
     */
    fun isActivityExists(packageName: String, className: String): Boolean {
        val intent = Intent()
        intent.setClassName(packageName, className)
        return !(Utils.getContext().packageManager.resolveActivity(intent, 0) == null ||
                intent.resolveActivity(Utils.getContext().packageManager) == null ||
                Utils.getContext().packageManager.queryIntentActivities(intent, 0).size == 0)
    }

    /**
     * 启动Activity

     * @param activity activity
     * *
     * @param cls      activity类
     */
    fun startActivity(activity: Activity, cls: Class<*>) {
        startActivity(activity, null, activity.packageName, cls.name, null)
    }

    /**
     * 启动Activity

     * @param extras   extras
     * *
     * @param activity activity
     * *
     * @param cls      activity类
     */
    fun startActivity(extras: Bundle,
                      activity: Activity,
                      cls: Class<*>) {
        startActivity(activity, extras, activity.packageName, cls.name, null)
    }

    /**
     * 启动Activity

     * @param activity  activity
     * *
     * @param cls       activity类
     * *
     * @param enterAnim 入场动画
     * *
     * @param exitAnim  出场动画
     */
    fun startActivity(activity: Activity,
                      cls: Class<*>,
                      @AnimRes enterAnim: Int,
                      @AnimRes exitAnim: Int) {
        startActivity(activity, null, activity.packageName, cls.name, null)
        activity.overridePendingTransition(enterAnim, exitAnim)
    }

    /**
     * 启动Activity

     * @param extras    extras
     * *
     * @param activity  activity
     * *
     * @param cls       activity类
     * *
     * @param enterAnim 入场动画
     * *
     * @param exitAnim  出场动画
     */
    fun startActivity(extras: Bundle,
                      activity: Activity,
                      cls: Class<*>,
                      @AnimRes enterAnim: Int,
                      @AnimRes exitAnim: Int) {
        startActivity(activity, extras, activity.packageName, cls.name, null)
        activity.overridePendingTransition(enterAnim, exitAnim)
    }

    /**
     * 启动Activity

     * @param activity activity
     * *
     * @param cls      activity类
     * *
     * @param options  跳转动画
     */
    fun startActivity(activity: Activity,
                      cls: Class<*>,
                      options: Bundle) {
        startActivity(activity, null, activity.packageName, cls.name, options)
    }

    /**
     * 启动Activity

     * @param extras   extras
     * *
     * @param activity activity
     * *
     * @param cls      activity类
     * *
     * @param options  跳转动画
     */
    fun startActivity(extras: Bundle,
                      activity: Activity,
                      cls: Class<*>,
                      options: Bundle) {
        startActivity(activity, extras, activity.packageName, cls.name, options)
    }

    /**
     * 启动Activity

     * @param pkg 包名
     * *
     * @param cls 全类名
     */
    fun startActivity(pkg: String, cls: String) {
        startActivity(Utils.getContext(), null, pkg, cls, null)
    }

    /**
     * 启动Activity

     * @param extras extras
     * *
     * @param pkg    包名
     * *
     * @param cls    全类名
     */
    fun startActivity(extras: Bundle,
                      pkg: String,
                      cls: String) {
        startActivity(Utils.getContext(), extras, pkg, cls, extras)
    }

    /**
     * 启动Activity

     * @param pkg     包名
     * *
     * @param cls     全类名
     * *
     * @param options 动画
     */
    fun startActivity(pkg: String,
                      cls: String,
                      options: Bundle) {
        startActivity(Utils.getContext(), null, pkg, cls, options)
    }

    /**
     * 启动Activity

     * @param extras  extras
     * *
     * @param pkg     包名
     * *
     * @param cls     全类名
     * *
     * @param options 动画
     */
    fun startActivity(extras: Bundle,
                      pkg: String,
                      cls: String,
                      options: Bundle) {
        startActivity(Utils.getContext(), extras, pkg, cls, options)
    }

    private fun startActivity(context: Context,
                              extras: Bundle?,
                              pkg: String,
                              cls: String,
                              options: Bundle?) {
        val intent = Intent(Intent.ACTION_VIEW)
        if (extras != null) intent.putExtras(extras)
        intent.component = ComponentName(pkg, cls)
        if (context !is Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        if (options == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            context.startActivity(intent)
        } else {
            context.startActivity(intent, options)
        }
    }

    /**
     * 获取launcher activity

     * @param packageName 包名
     * *
     * @return launcher activity
     */
    fun getLauncherActivity(packageName: String): String {
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val pm = Utils.getContext().packageManager
        val info = pm.queryIntentActivities(intent, 0)
        for (aInfo in info) {
            if (aInfo.activityInfo.packageName == packageName) {
                return aInfo.activityInfo.name
            }
        }
        return "no " + packageName
    }


    /**
     * 获取栈顶Activity

     * @return 栈顶Activity
     */
    fun getTopActivity(): Activity? {
        try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            val activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null)
            val activitiesField = activityThreadClass.getDeclaredField("mActivities")
            activitiesField.isAccessible = true
            var activities: Map<Any, Any>
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                activities = activitiesField.get(activityThread) as HashMap<Any, Any>
            } else {
                activities = activitiesField.get(activityThread) as ArrayMap<Any, Any>
            }
            for (activityRecord in activities.values) {
                val activityRecordClass = activityRecord.javaClass
                val pausedField = activityRecordClass.getDeclaredField("paused")
                pausedField.isAccessible = true
                if (!pausedField.getBoolean(activityRecord)) {
                    val activityField = activityRecordClass.getDeclaredField("activity")
                    activityField.isAccessible = true
                    return activityField.get(activityRecord) as Activity
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }
}