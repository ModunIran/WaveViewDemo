package com.wulei.base.activity

import android.os.Bundle

/**
 * Created by wulei on 2018/2/11.
 */
abstract class BaseBindingActivity:BaseActivity(){

    abstract fun initBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }
}