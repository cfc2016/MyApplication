package com.android.myapplication.home.mvp

import com.android.common_config.net.helper.RxSchedulers
import com.android.myapplication.config.http.BaseBean
import com.android.myapplication.config.http.BaseModel
import io.reactivex.Observer

class HomeModel : BaseModel() {


    /**
     * 首页数据
     */
    fun getHomeData(id:Long, observer: Observer<BaseBean<Any>>) {
        val hashMap = mutableMapOf<String,Any>()
        hashMap["id"] = id
        rxApi.getHomeData(getRequestBody(hashMap))
            .compose<BaseBean<Any>>(RxSchedulers.io_main())
            .subscribe(observer)
    }


}