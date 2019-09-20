package com.android.myapplication.config.http

import android.text.TextUtils
import com.android.common_config.net.helper.DefaultErrorCode
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *自定义异常类
 *@time 2019/6/19 11:41
 */
class CustomException: RuntimeException {
    var code: Int = 0
    var msg: String?

    constructor(code: Int, message: String?) : super(message) {
        if (TextUtils.isEmpty(message)) this.msg = "$code" else this.msg = message
        this.code = code

    }

    constructor(throwable: Throwable) : super(throwable) {
        var code = DefaultErrorCode.UNKNOW
        var message = throwable.message
        if (TextUtils.isEmpty(message)) message = "$code"
        if (throwable is UnknownHostException) {
            code = DefaultErrorCode.UNKNOWN_HOST
        } else if (throwable is SocketTimeoutException || throwable is ConnectException) {
            code = DefaultErrorCode.TIME_OUT
            message = "网络连接超时，请重试"
        }
        this.code = code
        this.msg = message
    }

    override fun toString(): String {
        return "错误码：" + code +
                "," + msg + '\''
    }
}