package com.model.basemodel.ui.activity.credit


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.model.basemodel.R


/**
 * 创建时间： 2017/7/28
 * 作者：WangZhuang
 * 功能描述：信用模块主Fragment
 */
class CreditFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view:View = inflater!!.inflate(R.layout.fragment_credit, container, false)
        return view
    }
}
