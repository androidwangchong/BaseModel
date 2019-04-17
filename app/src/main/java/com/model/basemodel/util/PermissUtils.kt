package com.model.basemodel.util

import android.app.Activity
import android.os.Build
import com.model.basemodel.permissionhandler.PermissionsManager
import com.model.basemodel.permissionhandler.PermissionsResultAction

/**
 * 校验权限
 *
 * @return
 */
fun Activity.checkSelfPermission(): Boolean {

    //6.0以上系统，请求权限
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return true
    }

    PermissionsManager.instance.requestAllManifestPermissionsIfNecessary(this, object : PermissionsResultAction() {
        override fun onGranted() {}

        override fun onDenied(permission: String) {
            //                finish();
        }
    })

    return true
}


//使用时在activity中重写此方法
//fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
//                               grantResults: IntArray) {
//    PermissionsManager.instance.notifyPermissionsChange(permissions, grantResults)
//}
