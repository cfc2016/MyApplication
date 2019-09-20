package com.android.myapplication.config.callback

import android.content.Context
import android.view.View
import com.android.myapplication.R
import com.kingja.loadsir.callback.Callback

class LoadingCallBack : Callback() {

    override fun onCreateView(): Int {
        return R.layout.view_loading
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}