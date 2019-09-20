package com.android.myapplication.config.callback

import android.content.Context
import android.view.View
import com.android.myapplication.R
import com.kingja.loadsir.callback.Callback

class LoadingHasContentCallBack : Callback() {

    override fun onCreateView(): Int {
        return R.layout.view_loading
    }

    override fun getSuccessVisible(): Boolean {
        return true
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}