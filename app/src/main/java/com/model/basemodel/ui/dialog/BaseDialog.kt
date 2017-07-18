package com.model.basemodel.ui.dialog

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.model.basemodel.ui.activity.base.IBase

/**
 * yimai_android
 * Created by wangchong on 2017/6/27.
 */
abstract class BaseDialog : IBase, DialogFragment() {

    abstract val layoutResId: Int
    abstract override fun initView()
    abstract override fun initData()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(layoutResId, container, false)
        return view
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

}