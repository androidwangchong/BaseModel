package com.model.basemodel.ui.adapter

/**
 * Created by wangchong on 17/2/14.
 */

import android.content.Context
import android.view.LayoutInflater
import android.widget.BaseAdapter

import java.util.ArrayList

abstract class AdapterBase<T> : BaseAdapter {

    private var mList: MutableList<T>? = null
    /**
     * Get parent context.

     * @return Context
     */
    open var context: Context? = null
        set
    /**
     * Get layout inflater.

     * @return LayoutInflater
     */
    /**
     * Set layout inflater.

     * @param layoutInflater
     * *            Layout inflater
     */
    var layoutInflater: LayoutInflater? = null

    constructor(context: Context) {
        this.context = context
        layoutInflater = LayoutInflater.from(this.context)
    }

    constructor(context: Context, list: MutableList<T>) {
        this.context = context
        mList = list
        layoutInflater = LayoutInflater.from(this.context)
    }

    override fun getCount(): Int {
        if (mList == null) {
            return 0
        }
        return mList!!.size
    }

    override fun getItem(pPosition: Int): T {
        return mList!![pPosition]
    }

    override fun getItemId(pPosition: Int): Long {
        return pPosition.toLong()
    }

    /**
     * Get content list.

     * @return List
     */
    /**
     * Set content list.

     * @param list
     * *            Content list
     */
    var list: MutableList<T>
        get() {
            if (mList == null) {
                mList = ArrayList<T>()
            }
            return mList as MutableList<T>
        }
        set(list) {
            mList = list
            notifyDataSetChanged()
        }

    fun appendList(list: List<T>) {
        if (mList == null) {
            mList = ArrayList<T>()
        }
        mList?.addAll(list)
        notifyDataSetChanged()
    }

    fun append(t: T) {
        if (mList == null) {
            mList = ArrayList<T>()
        }
        mList?.add(t)
    }

    fun clear() {
        if (mList == null) {
            mList = ArrayList<T>()
        }
        mList?.clear()
    }

}
