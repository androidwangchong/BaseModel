package com.model.basemodel.util

import android.text.TextUtils
import android.util.Log


/**
 * BaseModel
 * Created by wangchong on 2017/7/17.
 */
object LogUtil {
    /**
     * 默认每次缩进两个空格
     */
    private val empty = "  "

    fun formatToJson(tag: String, json: String) {
        try {
            var empty = 0
            val chs = json.toCharArray()
            val stringBuilder = StringBuilder()
            var i = 0
            while (i < chs.size) {
                //若是双引号，则为字符串，下面if语句会处理该字符串
                if (chs[i] == '\"') {

                    stringBuilder.append(chs[i])
                    i++
                    //查找字符串结束位置
                    while (i < chs.size) {
                        //如果当前字符是双引号，且前面有连续的偶数个\，说明字符串结束
                        if (chs[i] == '\"' && isDoubleSerialBackslash(chs, i - 1)) {
                            stringBuilder.append(chs[i])
                            i++
                            break
                        } else {
                            stringBuilder.append(chs[i])
                            i++
                        }

                    }
                } else if (chs[i] == ',') {
                    stringBuilder.append(',').append('\n').append(getEmpty(empty))

                    i++
                } else if (chs[i] == '{' || chs[i] == '[') {
                    empty++
                    stringBuilder.append(chs[i]).append('\n').append(getEmpty(empty))

                    i++
                } else if (chs[i] == '}' || chs[i] == ']') {
                    empty--
                    stringBuilder.append('\n').append(getEmpty(empty)).append(chs[i])

                    i++
                } else {
                    stringBuilder.append(chs[i])
                    i++
                }


            }
            Log.d(tag, stringBuilder.toString())
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            Log.d(tag, e.printStackTrace().toString())
        }

    }

    private fun isDoubleSerialBackslash(chs: CharArray, i: Int): Boolean {
        var count = 0
        for (j in i downTo -1 + 1) {
            if (chs[j] == '\\') {
                count++
            } else {
                return count % 2 == 0
            }
        }

        return count % 2 == 0
    }

    /**
     * 缩进
     * @param count
     * *
     * @return
     */
    private fun getEmpty(count: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0..count - 1) {
            stringBuilder.append(empty)
        }

        return stringBuilder.toString()
    }
}