package com.model.basemodel.util

import android.app.Activity
import android.content.Intent
import com.model.basemodel.R
import com.model.basemodel.ui.activity.login.LoginActivity

/**
 * 启动登录页面
 */
fun Activity.openLoginActivity() {
    val intent = Intent(this, LoginActivity::class.java)
    this.startActivity(intent)
    this.overridePendingTransition(R.anim.activity_open, 0)
}
