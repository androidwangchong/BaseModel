package com.model.basemodel.http.demoApi

import com.model.basemodel.http.ApiFactory
import com.model.basemodel.http.EnqueueCallback
import com.model.basemodel.http.apiconfig.model

/**
 * BaseModel
 * Created by wangchong on 2017/10/30.
 */
fun userInfo() {
    ApiFactory.getDemoAPI()
            ?.userInfo()
            ?.enqueue(EnqueueCallback<model>())
}