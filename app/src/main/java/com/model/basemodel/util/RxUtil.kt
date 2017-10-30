package com.model.basemodel.util

import android.app.Activity
import android.support.v4.app.Fragment
import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import java.util.concurrent.TimeUnit

/**
 * hzx-andriod
 * Created by wangchong on 2017/8/7.
 */
/**
 * 100毫秒
 */
fun click(view: View, click: (View) -> Unit) {
    RxView.clicks(view).throttleFirst(100, TimeUnit.MILLISECONDS)
            .subscribe {
                click(view)
            }
}

/**
 * 1000毫秒
 */
fun clickThrottleFirst(view: View, click: (View) -> Unit) {
    RxView.clicks(view).throttleFirst(1, TimeUnit.SECONDS)
            .subscribe {
                click(view)
            }
}
/**
 * 1000毫秒 多个view
 */
fun clicksWithThrottleFirst(view: MutableList<View>, vararg click: (View) -> Unit) {
    (0 until view.size).forEach { i ->
        view[i].let {
            RxView.clicks(view[i]).throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe {
                        click[i].let { click[i](view[i]) }
                    }
        }
    }
}
//fun Fragment.click(view: View, click: (View) -> Unit) {
//    RxView.clicks(view).throttleFirst(100, TimeUnit.MILLISECONDS)
//            .subscribe {
//                click(view)
//            }
//}
//fun Fragment.clickThrottleFirst(view: View, click: (View) -> Unit) {
//    RxView.clicks(view).throttleFirst(1, TimeUnit.SECONDS)
//            .subscribe {
//                click(view)
//            }
//}