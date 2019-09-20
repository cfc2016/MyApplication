package com.android.myapplication.config.http

import com.android.common_config.net.DefaultRetrofitUtil
import com.google.gson.GsonBuilder
import okhttp3.MediaType
import okhttp3.RequestBody

/**
 *model基类
 *@time 2019/6/19 11:41
 */
open class BaseModel: IBaseModel {


    override fun getRequestBody(map:MutableMap<String,Any>): RequestBody {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonBuilder().disableHtmlEscaping().create().toJson(map))
    }

    override val rxApi: ApiService
        get() = DefaultRetrofitUtil.getInstance().retrofit?.create(ApiService::class.java)!!
}