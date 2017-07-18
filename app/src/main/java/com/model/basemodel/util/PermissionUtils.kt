package com.model.basemodel.util

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

import java.util.ArrayList

/**
 * <pre>
 * author: Blankj
 * blog  : http://blankj.com
 * time  : 2017/04/16
 * desc  : 权限相关工具类
</pre> *
 */
object PermissionUtils {

    private var mRequestCode = -1

    private var mOnPermissionListener: OnPermissionListener? = null

    interface OnPermissionListener {

        fun onPermissionGranted()

        fun onPermissionDenied(deniedPermissions: Array<String>)
    }

    abstract class RationaleHandler {
        private var context: Context? = null
        private var requestCode: Int = 0
        private var permissions: Array<String>? = null

        protected abstract fun showRationale()

        internal fun showRationale(context: Context, requestCode: Int, permissions: Array<String>) {
            this.context = context
            this.requestCode = requestCode
            this.permissions = permissions
            showRationale()
        }

        @TargetApi(Build.VERSION_CODES.M)
        fun requestPermissionsAgain() {
            (context as Activity).requestPermissions(permissions!!, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @JvmOverloads fun requestPermissions(context: Context, requestCode: Int, permissions: Array<String>, listener: OnPermissionListener, handler: RationaleHandler? = null) {
        if (context is Activity) {
            mRequestCode = requestCode
            mOnPermissionListener = listener
            val deniedPermissions = getDeniedPermissions(context, permissions)
            if (deniedPermissions.size > 0) {
                val rationale = shouldShowRequestPermissionRationale(context, *deniedPermissions)
                if (rationale && handler != null) {
                    handler.showRationale(context, requestCode, deniedPermissions)
                } else {
                    context.requestPermissions(deniedPermissions, requestCode)
                }
            } else {
                if (mOnPermissionListener != null)
                    mOnPermissionListener!!.onPermissionGranted()
            }
        } else {
            throw RuntimeException("Context must be an Activity")
        }
    }

    /**
     * 请求权限结果，对应Activity中onRequestPermissionsResult()方法。
     */
    fun onRequestPermissionsResult(context: Activity, requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (mRequestCode != -1 && requestCode == mRequestCode) {
            if (mOnPermissionListener != null) {
                val deniedPermissions = getDeniedPermissions(context, permissions)
                if (deniedPermissions.size > 0) {
                    mOnPermissionListener!!.onPermissionDenied(deniedPermissions)
                } else {
                    mOnPermissionListener!!.onPermissionGranted()
                }
            }
        }
    }

    /**
     * 获取请求权限中需要授权的权限
     */
    private fun getDeniedPermissions(context: Context, permissions: Array<String>): Array<String> {
        val deniedPermissions = ArrayList<String>()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission)
            }
        }
        return deniedPermissions.toTypedArray()
    }

    /**
     * 是否彻底拒绝了某项权限
     */
    fun hasAlwaysDeniedPermission(context: Context, vararg deniedPermissions: String): Boolean {
        for (deniedPermission in deniedPermissions) {
            if (!shouldShowRequestPermissionRationale(context, deniedPermission)) {
                return true
            }
        }
        return false
    }

    /**
     * 是否有权限需要说明提示
     */
    private fun shouldShowRequestPermissionRationale(context: Context, vararg deniedPermissions: String): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return false
        var rationale: Boolean
        for (permission in deniedPermissions) {
            rationale = ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission)
            if (rationale) return true
        }
        return false
    }
}
