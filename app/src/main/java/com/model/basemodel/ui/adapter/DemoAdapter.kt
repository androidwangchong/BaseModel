package com.model.basemodel.ui.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.model.basemodel.http.api.model
import com.model.basemodel.ui.adapter.view.DemoView

/**
 * BaseModel
 * Created by wangchong on 2017/7/17.
 */
class DemoAdapter(private var mContext: Context) : AdapterBase<model>(mContext) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val personItemView: View
        if (convertView == null) {
            personItemView = (mContext as Activity).DemoView(getItem(position))
        } else {
            personItemView = convertView
        }

        return personItemView
    }

}