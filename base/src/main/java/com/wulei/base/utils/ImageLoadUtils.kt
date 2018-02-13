package com.wulei.base.utils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.wulei.base.GlideApp

/**
 * Created by wulei on 2018/2/6.
 */
object ImageLoadUtils {

    @BindingAdapter("imgUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView,url:String){
        GlideApp.with(imageView.context)
                .load(url)
                .into(imageView)
    }


    @BindingAdapter("imgUrl","placeHolder")
    @JvmStatic
    fun loadImage(imageView: ImageView,url:String,placeHolder:Drawable){
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeHolder)
                .into(imageView)
    }

    @BindingAdapter("imgUrl","placeHolder","errImg")
    @JvmStatic
    fun loadImage(imageView: ImageView,url:String,placeHolder:Drawable,errorImg:Drawable){
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeHolder)
                .error(errorImg)
                .into(imageView)
    }

    @BindingAdapter("imgUrl","radius")
    @JvmStatic
    fun loadRoundImage(imageView: ImageView,url:String,radius:Int){
        GlideApp.with(imageView.context)
                .load(url)
                .transform(RoundedCorners(radius))
                .into(imageView)
    }

    @BindingAdapter("imgUrl","radius","placeHolder")
    @JvmStatic
    fun loadRoundImage(imageView: ImageView,url:String,radius:Int,placeHolder: Drawable){
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeHolder)
                .transform(RoundedCorners(radius))
                .into(imageView)
    }

    @BindingAdapter("imgUrl","radius","placeHolder","errImg")
    @JvmStatic
    fun loadRoundImage(imageView: ImageView,url:String,radius:Int,placeHolder: Drawable,errorImg:Drawable){
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeHolder)
                .error(errorImg)
                .transform(RoundedCorners(radius))
                .into(imageView)
    }
    /**
     * 缩略图 (Thumbnail) 请求
     * 大图用
     */

    @BindingAdapter("imgUrl","sizeMultiplier")
    @JvmStatic
    fun loadImageWithThumbnail(imageView: ImageView,url:String,sizeMultiplier:Float){
        GlideApp.with(imageView.context)
                .load(url)
                .thumbnail(sizeMultiplier)
                .into(imageView)
    }

    @BindingAdapter("imgUrl","placeHolder","sizeMultiplier")
    @JvmStatic
    fun loadImageWithThumbnail(imageView: ImageView,url:String,placeHolder: Drawable,sizeMultiplier:Float){
        GlideApp.with(imageView.context)
                .load(url)
                .placeholder(placeHolder)
                .thumbnail(sizeMultiplier)
                .into(imageView)
    }



}