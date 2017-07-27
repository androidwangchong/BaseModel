package com.model.basemodel.http.api

/**
 * BaseModel
 * Created by wangchong on 2017/7/20.
 */
object HttpHeaderConfig {

    fun loginHeader(): Map<String, String> {
        val map = mutableMapOf<String, String>().apply {
            put("User-Agent", "ttdevs") //https://developer.github.com/v3/#user-agent-required
            put("Content-Type", "application/json; charset=utf-8")
            put("Accept", "application/json")
            put("Accept", "application/vnd.github.v3+json") //https://developer.github.com/v3/#current-version
            put("token", "eATQzos9vG9hFK4Uk218")
            put("Time-Zone", "Asia/Shanghai") //https://developer.github.com/v3/#timezones
            put("user_key", "haha")
        }

        return map
    }


}