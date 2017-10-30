package com.model.basemodel.http

import de.greenrobot.event.EventBus
import retrofit2.Response

/**
 * hzx-andriod
 * Created by wangchong on 2017/8/11.
 */
object HttpCommonUtil {
    fun <T> putMessageToActivity(p1: Response<T>?) {
        if (p1?.code() == 200) {
            when (p1.headers()?.get("error-code").isNullOrEmpty()) {
                true -> {
                    EventBus.getDefault().post(p1.body() ?: "")
                }
                false -> {
                    return
                }
            }
        } else {
            //错误处理
        }

    }

}