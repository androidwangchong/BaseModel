package com.model.basemodel.ui.widget


import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet


import com.model.basemodel.R

import java.util.ArrayList

/**
 * Created by wangchong on 2017/4/21.
 */

class RongDivisionEditText : android.support.v7.widget.AppCompatEditText {

    private var mSperator: String? = null
    // 存放需分隔处文本窗独
    private val groupCoords = ArrayList<Int>()
    // 记录上次增减文本的长度，判断本次添加还是删除
    private val mLastLength = 0
    // xml文件设置的输入长度
    private var mTotalLength: Int = 0
    // 记录加上分隔符后总长度
    private var mLength: Int = 0
    // 当前输入类型
    private var mType: Int = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        inputType = InputType.TYPE_CLASS_NUMBER
        val typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.RongDivisionEditText)
        if (typedArray != null) {
            mTotalLength = 16
            mSperator = typedArray.getString(R.styleable.RongDivisionEditText_sperator)
            if (TextUtils.isEmpty(mSperator)) {
                mSperator = DEFAULT_DIVIDE_SYMBOL
            }
            mType = typedArray.getInt(R.styleable.RongDivisionEditText_type, BANK_TYPE)
            if (mType == BANK_TYPE) {
                // 计算需要几个分隔符及每个对应的长度
                val mode = mTotalLength % DEFAULT_BANK_CARD_LENGTH
                val divider = mTotalLength / DEFAULT_DIVIDE_LENGTH
                val groupCoordsLength = if (mode == 0) divider - 1 else divider
                this.mLength = mTotalLength + groupCoordsLength
                for (i in 1..groupCoordsLength + 1 - 1) {
                    groupCoords.add(i * (DEFAULT_DIVIDE_LENGTH + 1) - 1)
                }
                typedArray.recycle()
            } else {
                initPhoneGroupCoords()
                this.mLength = DEFAULT_PHONE_NUMBER_LENGTH + groupCoords.size
            }

            maxWidth = mLength
        }
        addTextChangedListener(DivisionTextWatcher())
    }

    private fun initPhoneGroupCoords() {
        //这里偷懒了，不计算了，手机号默认这么分了。。。。懒。。。
        groupCoords.add(3)
        groupCoords.add(8)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    /**
     * 获取文本框输入的内容，自动替换掉分隔符

     * @return
     */
    val content: String
        get() = text.toString().trim { it <= ' ' }.replace(mSperator!!, "")

    private inner class DivisionTextWatcher : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s == null || s.length == 0) return
            val sb = StringBuilder()
            for (i in 0..s.length - 1) {
                if (i != 3 && i != 8 && s[i] == ' ') {
                    continue
                } else {
                    sb.append(s[i])
                    if ((sb.length == 4 || sb.length == 9) && sb[sb.length - 1] != ' ') {
                        sb.insert(sb.length - 1, ' ')
                    }
                }
            }
            if (sb.toString() != s.toString()) {
                var index = start + 1
                if (sb[start] == ' ') {
                    if (before == 0) {
                        index++
                    } else {
                        index--
                    }
                } else {
                    if (before == 1) {
                        index--
                    }
                }
                this@RongDivisionEditText.setText(sb.toString())
                this@RongDivisionEditText.setSelection(index)
            }
        }

        override fun afterTextChanged(s: Editable) {

        }
    }

    companion object {

        private val TAG = "RongDivisionEditText"

        private val PHONE_TYPE = 1

        private val BANK_TYPE = 2

        private val DEFAULT_BANK_CARD_LENGTH = 16

        private val DEFAULT_PHONE_NUMBER_LENGTH = 11

        private val DEFAULT_DIVIDE_LENGTH = 4

        private val DEFAULT_DIVIDE_SYMBOL = "-"
    }

}