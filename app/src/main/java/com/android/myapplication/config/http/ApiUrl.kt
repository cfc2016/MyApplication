package com.android.myapplication.config.http


object ApiUrl {
    var appBaseUrl = ""    //接口地址
    var uploadTokenUrl = ""//七牛上传token地址
    var h5Url = ""//h5域名地址


    //测试
    const val APP_TEST_URL = "https://tjzyd.imyxg.com/service/"
    const val UPLOAD_TEST_URL = "https://tjzyd.imyxg.com/service/"
    const val H5_TEST_URL = ""


    //线上
    const val APP_RELEASE_URL = "https://jzyd.imyxg.com/service/"
    const val UPLOAD_RELEASE_URL = "https://jzyd.imyxg.com/service/"
    const val H5_RELEASE_URL = ""


    /**
     * 七牛云上传获取token
     */
    const val GET_UPLOAD_TOKEN = "auth/qiNiu/uploadToken"

    /**
     * 登录
     */
    const val LOGIN = "auth/login"



  }