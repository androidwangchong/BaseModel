package com.model.basemodel.dslbuilder

import com.model.basemodel.app.MyApplication
import com.model.basemodel.ui.widget.Toaster

fun Toast(block: ToasterBuilder.() -> Unit): Unit = ToasterBuilder().apply(block).build()


class ToasterBuilder {
    var content: String = ""
    fun build(): Unit = Toaster.showCenter(MyApplication.instance(), content)
}
