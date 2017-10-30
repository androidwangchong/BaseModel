package com.model.basemodel.http.demoApi

import com.model.basemodel.http.apiconfig.HttpHeaderConfig.loginHeader
import com.model.basemodel.http.apiconfig.model
import retrofit2.Call
import retrofit2.http.*


/**
 * BaseModel
 * Created by wangchong on 2017/7/14.
 */
interface DemoAPI {

    @GET("BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=关键字&bk_length=600")
    fun userInfo(@HeaderMap map: Map<String, String> = loginHeader()): Call<model>

}