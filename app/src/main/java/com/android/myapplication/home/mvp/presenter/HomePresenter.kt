package com.android.myapplication.home.mvp.presenter

import com.android.common_config.mvp.BasePresenter
import com.android.myapplication.config.http.BaseObserver
import com.android.myapplication.config.http.CustomException
import com.android.myapplication.home.mvp.HomeModel
import com.android.myapplication.home.mvp.contract.HomeContract


class HomePresenter : BasePresenter<HomeContract.IHomeView>(),
    HomeContract.IHomePresenter {
    override fun getHome(id: Long) {

        val rxBaseObserver = object : BaseObserver<Any>() {
            override fun onStart() {
                view.showLoading(true)
            }

            override fun success(data: Any?, code: Int?, message: String?) {
                view.getHomeSuc(data)
                view.showContent()
            }

            override fun fail(e: CustomException, code: Int?, message: String?) {
                view.showContent()
            }
        }
        mHomeModel.getHomeData(id,rxBaseObserver)
        addDisposable(rxBaseObserver)
    }

    private var mHomeModel: HomeModel = HomeModel()






}