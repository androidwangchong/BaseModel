package com.model.basemodel.http

import android.util.Log

import java.io.IOException
import java.lang.reflect.Type
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

/**
 * author: baiiu
 * date: on 16/8/10 20:19
 * description:
 */
class StringConverter : Converter.Factory() {

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?,
                                       retrofit: Retrofit?): Converter<ResponseBody, *>? {
        Log.d("type: ", type!!.toString())

        if (type === String::class.java) {
            return StringResponseBodyConverter.INSTANCE
        }

        return null
    }

    internal class StringResponseBodyConverter : Converter<ResponseBody, String> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): String {
            return value.string()
        }

        companion object {
            val INSTANCE = StringResponseBodyConverter()
        }
    }

    companion object {

        fun create(): Converter.Factory {
            return StringConverter()
        }
    }

}
