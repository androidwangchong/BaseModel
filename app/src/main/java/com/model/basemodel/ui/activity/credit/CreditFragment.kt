package com.model.basemodel.ui.activity.credit


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.model.basemodel.R


/**
 * A simple [Fragment] subclass.
 */
class CreditFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_credit, container, false)
    }

}// Required empty public constructor
