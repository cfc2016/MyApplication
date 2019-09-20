package com.android.myapplication.config.callback

import android.content.Context
import android.view.View
import com.android.myapplication.R
import com.kingja.loadsir.callback.Callback

class EmptyCallBack : Callback() {

    override fun onCreateView(): Int  = R.layout.view_empty

    override fun onViewCreate(context: Context?, view: View?) {
        view?.isClickable = false
    }
}