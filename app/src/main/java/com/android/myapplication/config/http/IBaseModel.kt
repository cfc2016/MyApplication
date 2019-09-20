package com.android.myapplication.config.http

import okhttp3.RequestBody


/**
 *model接口类
 *@time 2019/6/19 11:41
 */
interface IBaseModel {
    val rxApi: ApiService

    fun getRequestBody(map:MutableMap<String,Any>): RequestBody
}
