package com.model.basemodel.ui.adapter.view

import android.app.Activity
import android.view.View
import android.widget.LinearLayout
import com.model.basemodel.R
import com.model.basemodel.http.apiconfig.model
import kotlinx.android.synthetic.main.view_demo.*
import org.jetbrains.anko.UI
import org.jetbrains.anko.include
import org.jetbrains.anko.linearLayout

/**
 * BaseModel
 * Created by wangchong on 2017/7/17.
 */

fun Activity.demoView(m: model): View {

    val view = UI {
        include<View>(R.layout.view_demo)
    }.view

    decs.text = m.title
    return view

}
