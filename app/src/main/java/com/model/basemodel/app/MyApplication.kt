package com.model.basemodel.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.model.basemodel.http.OKHttpFactory
import com.model.basemodel.http.apiconfig.HttpConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import java.io.IOException


/**
 * BaseModel
 * Created by wangchong on 2017/7/14.
 */
class MyApplication : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLoggerInfo()
        initUatCer()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    fun initLoggerInfo() {
//        var formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(true)   //（可选）是否显示线程信息。默认值为true
//                .methodCount(2)          //（可选）要显示的方法行数。默认值2
//                .methodOffset(5)         //（可选）隐藏内部方法调用到偏移量。默认5
////        .logStrategy(customLog)//（可选）更改要打印的日志策略。默认LogCat
////                .tag("我的自定义标签")    //（可选）每个日志的全局标签。默认PRETTY_LOGGER
//                .build()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    fun initUatCer() {
        if (HttpConfig.IS_UAT) {
            try {
                OKHttpFactory.setCertificates(assets.open("uat_dev_hrx_ai.cer"))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}