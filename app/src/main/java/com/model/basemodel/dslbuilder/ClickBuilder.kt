package com.model.basemodel.dslbuilder

import android.app.Activity
import android.view.View
import com.model.basemodel.util.click
import com.model.basemodel.util.clickThrottleFirst


fun Activity.ClickView(block: ClickViewBuilder.() -> Unit): Unit = ClickViewBuilder().apply(block).build()


class ClickViewBuilder {
    var view: View? = null
    var isThrottleFirst = true
    internal var todo: (View) -> Unit = {}

    private fun onClick() {
        if (isThrottleFirst) {
            clickThrottleFirst(view!!) {
                todo(view!!)
            }
        } else {
            click(view!!) {
                todo(view!!)
            }
        }
    }

    fun build(): Unit = onClick()
}