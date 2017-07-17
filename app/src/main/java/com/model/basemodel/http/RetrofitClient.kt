package com.model.basemodel.http


import com.model.basemodel.http.api.HttpConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * BaseModel
 * Created by wangchong on 2017/7/14.
 */
object RetrofitClient {

    var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                //设置OKHttpClient
                .client(OKHttpFactory.okHttpClient)

                //baseUrl
                .baseUrl(HttpConfig.SERVER_URL)

                //string转化器
                .addConverterFactory(StringConverter.create())

                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())

                //Rx
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                //创建
                .build()
    }
}
