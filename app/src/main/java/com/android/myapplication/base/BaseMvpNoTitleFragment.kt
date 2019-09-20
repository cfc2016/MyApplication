package com.android.myapplication.base

import com.android.common_config.mvp.BaseMvpFragment
import com.android.myapplication.config.callback.EmptyCallBack
import com.android.myapplication.config.callback.LoadingCallBack
import com.android.myapplication.config.callback.LoadingHasContentCallBack


abstract class BaseMvpNoTitleFragment : BaseMvpFragment() {

    override fun showEmpty() {
        loadService!!.showCallback(EmptyCallBack::class.java)
    }


    override fun showLoading(showContent: Boolean) {
        if (showContent) {
            loadService!!.showCallback(LoadingHasContentCallBack::class.java)
        } else {
            loadService!!.showCallback(LoadingCallBack::class.java)
        }
    }
}