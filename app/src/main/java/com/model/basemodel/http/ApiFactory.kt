package com.model.basemodel.http

import com.model.basemodel.http.api.DemoAPI

/**
 * BaseModel
 * Created by wangchong on 2017/7/14.
 */
object ApiFactory {

    private var demoAPI: DemoAPI? = null

    fun getDemoAPI(): DemoAPI? {
        if (demoAPI == null) {
            demoAPI = RetrofitClient.retrofit.create<DemoAPI>(DemoAPI::class.java)
        }
        return demoAPI
    }

}
