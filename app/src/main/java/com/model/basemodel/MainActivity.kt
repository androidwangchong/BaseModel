package com.model.basemodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.model.basemodel.http.RetrofitClient
import com.model.basemodel.http.api.DemoAPI
import com.model.basemodel.http.api.model
import com.model.basemodel.util.LogUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClient.retrofit.create(DemoAPI::class.java).userInfo().enqueue(
                object : Callback<model> {
                    override fun onFailure(p0: Call<model>?, p1: Throwable?) {

                    }

                    override fun onResponse(p0: Call<model>?, p1: Response<model>?) {
                        LogUtil.format("model", p1?.body().toString())

                    }
                }
        )

    }
}
