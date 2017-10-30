package com.model.basemodel.http

import com.orhanobut.logger.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * BaseModel
 * Created by wangchong on 2017/10/30.
 */
fun <T> EnqueueCallback(): Callback<T> = object : Callback<T> {
    override fun onResponse(p0: Call<T>?, p1: Response<T>?) {
        p1.let {
            HttpCommonUtil.putMessageToActivity(p1)
        }
    }

    override fun onFailure(p0: Call<T>?, p1: Throwable?) {
        Logger.e(p0?.request()?.url()?.toString() + "\n" + p1?.message + "\n" + p0?.request()?.body())
    }
}
