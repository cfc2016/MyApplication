package com.android.myapplication.config.http


import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

/**
 *api接口
 *@time 2019/6/19 11:40
 */
interface ApiService {


    /**
     * 首页
     */
    @POST(ApiUrl.LOGIN)
    fun getHomeData(@Body requestBody: RequestBody): Observable<BaseBean<Any>>



}