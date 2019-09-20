package com.android.myapplication.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.android.myapplication.config.callback.LoadingHasContentCallBack
import com.android.common_config.mvp.BaseMvpActivity
import com.android.common_config.utils.StatusBarUtil
import com.android.myapplication.R
import com.android.myapplication.common.widget.TitleView
import com.android.myapplication.config.callback.EmptyCallBack
import com.android.myapplication.config.callback.LoadingCallBack

import java.util.*


abstract class BaseMvpTitleActivity : BaseMvpActivity() {


    override fun setContentView(): Int = R.layout.activity_base_title

    private val mainContent by lazy {
        findViewById<FrameLayout>(R.id.fl_main_content)
    }

    private val baseTitle by lazy {
        findViewById<TitleView>(R.id.base_title_view)
    }

    override fun initData() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        StatusBarUtil.setStatusBarFullTransparent(this)
        StatusBarUtil.StatusBarLightMode(this)
        if (setTitleResId() > 0) baseTitle.setTitle(setTitleResId())
        val contentResId = setContentViewResId()
        if (contentResId > 0) View.inflate(mContext, contentResId, mainContent)
        initLoadLayout()//二次调用
        initContent()
        initListener()
    }

    abstract fun setTitleResId(): Int

    abstract fun setContentViewResId(): Int

    abstract fun initContent()

    protected open fun initListener() {

    }

    fun setMainTitle(stringResId: Int) {
        if (stringResId > 0)   baseTitle.setTitle(stringResId)
    }

    fun setMainTitle(stringTitle: String) {
        baseTitle.setTitle(stringTitle)
    }

    override fun setLoadSirTarget(): Any? {
        return mainContent
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

    fun finishAndStartActivity(clazz: Class<*>) {
        finish()
        val intent = Intent(this, clazz)
        startActivity(intent)
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