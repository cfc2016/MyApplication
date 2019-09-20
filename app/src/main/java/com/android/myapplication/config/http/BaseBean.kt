package com.android.myapplication.config.http

import com.android.common_config.net.bean.DefaultValue


/**
 *实体基类
 *@time 2019/4/25 18:12
 */
class BaseBean<T> : DefaultValue {
    val code: Int? = 0
        get() = defaultValue(field, 0)
    val message: String? = ""
        get() = defaultValue(field, "")
    val data: T? = null
}