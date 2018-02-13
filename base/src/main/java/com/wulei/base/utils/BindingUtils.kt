package com.wulei.base.utils

import android.databinding.BindingAdapter
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by wulei on 2018/2/11.
 */
object BindingUtils{
    @BindingAdapter("marginBottom")
    @JvmStatic
    fun setMarginBottom(imageView: ImageView, margin:Int){
        val params=imageView.layoutParams
        when(params){
            is ViewGroup.MarginLayoutParams->{
                params.bottomMargin = margin
                imageView.layoutParams=params
            }
        }

    }
    @BindingAdapter("marginTop")
    @JvmStatic
    fun setMarginTop(imageView: ImageView, margin:Int){
        val params=imageView.layoutParams
        when(params){
            is ViewGroup.MarginLayoutParams->{
                params.topMargin = margin
                imageView.layoutParams=params
            }
        }

    }
    @BindingAdapter("marginLeft")
    @JvmStatic
    fun setMarginLeft(imageView: ImageView, margin:Int){
        val params=imageView.layoutParams
        when(params){
            is ViewGroup.MarginLayoutParams->{
                params.leftMargin = margin
                imageView.layoutParams=params
            }
        }

    }
    @BindingAdapter("marginRight")
    @JvmStatic
    fun setMarginRight(imageView: ImageView, margin:Int){
        val params=imageView.layoutParams
        when(params){
            is ViewGroup.MarginLayoutParams->{
                params.rightMargin = margin
                imageView.layoutParams=params
            }
        }

    }
}