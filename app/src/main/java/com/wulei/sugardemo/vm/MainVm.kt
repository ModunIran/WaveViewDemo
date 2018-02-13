package com.wulei.sugardemo.vm

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.databinding.ObservableInt

/**
 * Created by wulei on 2018/2/11.
 */
class MainVm : BaseObservable() {

    interface Listener{
        fun onWaveClick()
    }
}