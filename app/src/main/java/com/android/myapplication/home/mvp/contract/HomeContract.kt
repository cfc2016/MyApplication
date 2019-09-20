package com.android.myapplication.home.mvp.contract

import com.android.common_config.mvp.IBaseView


class HomeContract {
    interface IHomePresenter {
        fun getHome(id:Long)
    }

    interface IHomeView : IBaseView {
        fun getHomeSuc(data: Any?)
    }
}