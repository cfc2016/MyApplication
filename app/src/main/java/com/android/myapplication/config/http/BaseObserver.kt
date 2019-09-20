package com.android.myapplication.config.http


import com.android.common_config.base.BaseApplication
import com.android.common_config.utils.NetCheckUtil
import com.android.common_config.utils.logee
import com.android.common_config.utils.toast
import io.reactivex.observers.DisposableObserver


/**
 *网络请求回调基类
 *@time 2019/4/25 19:18
 */
abstract class BaseObserver<T> : DisposableObserver<BaseBean<T>>() {

    override fun onStart() {
    }

    override fun onNext(tBaseBean: BaseBean<T>) {
        if (tBaseBean.code == 200) {
            try {
                success(tBaseBean.data,tBaseBean.code,tBaseBean.message)
            } catch (e: Exception) {
                onError(e)
            }
        } else {
            val customException = CustomException(tBaseBean.code!!, tBaseBean.message)
            toast(customException.msg)
            fail(customException,tBaseBean.code,tBaseBean.message)
          /*  if (tBaseBean.code == ErrorCode.TOKEN_EXPIRED||tBaseBean.code == ErrorCode.TOKEN_NOT_EXISTED||tBaseBean.code == ErrorCode.TOKEN_ILLEGAL) {
                UserManageHelper.reLogin()
            }*/
        }
    }


    override fun onError(e: Throwable) {
        logee(e.toString())
        if (e is CustomException){//当token失效时，会执行这里
            toast(e.msg)
            fail(e,e.code,e.message)

        }else{
            if (!NetCheckUtil.isAvailable(BaseApplication.context)){
                toast("网路异常")
            }
            val customException = CustomException(e)
            fail(customException,customException.code,customException.msg)
            toast(customException.msg)
        }
    }

    override fun onComplete() {

    }


    abstract fun success(data: T?, code: Int?, message: String?)

    open fun fail(e: CustomException, code: Int?, message: String?) {

    }

}
