package com.android.myapplication.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.widget.Toast
import com.android.common_config.mvp.BaseMvpActivity
import com.android.common_config.utils.StatusBarUtil
import com.android.myapplication.config.callback.EmptyCallBack
import com.android.myapplication.config.callback.LoadingCallBack
import com.android.myapplication.config.callback.LoadingHasContentCallBack

import java.util.*


abstract class BaseMvpNoTitleActivity : BaseMvpActivity() {

    override fun initData() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        StatusBarUtil.setStatusBarFullTransparent(this)
        StatusBarUtil.StatusBarLightMode(this)
//        initLoadLayout()//二次调用
        initContent()
    }

    abstract fun initContent()

    fun finishAndStartActivity(clazz: Class<*>) {
        finish()
        val intent = Intent(this, clazz)
        startActivity(intent)
    }

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





    override fun onStart() {
        super.onStart()
    }


    override fun onStop() {
        super.onStop()
    }



    fun showMyToast(toast: Toast, cnt: Long) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                toast.show()
            }
        }, 0, 3000)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                toast.cancel()
                timer.cancel()
            }
        }, cnt)
    }


}