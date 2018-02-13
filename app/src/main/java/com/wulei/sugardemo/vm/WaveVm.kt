package com.wulei.sugardemo.vm

import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.databinding.ObservableInt

/**
 * Created by wulei on 2018/2/13.
 */
class WaveVm:BaseObservable(){
    var avatarMargin = ObservableInt(0)
    var avatarUrl = ObservableField<String>("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/pic/item/1c950a7b02087bf490ce1fdefed3572c11dfcfe3.jpg")
}