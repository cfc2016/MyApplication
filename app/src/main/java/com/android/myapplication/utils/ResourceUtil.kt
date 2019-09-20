package com.android.myapplication.utils

import com.android.common_config.base.BaseApplication


/**
 * 资源文件工具类
 *
 */
object ResourceUtil {

    /**
     * 通过资源文件找到对应文字
     * @param resId
     * @return
     */
    fun getString(resId: Int): String {
        return BaseApplication.context.resources.getString(resId)
    }


    /**
     * 通过资源文件找到对应文字
     * @param resId
     * @return
     */
    fun getColor(resId: Int): Int {
        return BaseApplication.context.resources.getColor(resId)
    }
}
