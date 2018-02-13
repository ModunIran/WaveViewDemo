package com.wulei.uikit

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by wulei on 2018/2/10.
 */
class SugarWaveView : View {

    private val mAbovePath = Path()
    private val mBelowPath = Path()
    private val mAbovePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBelowPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val drawFilter = PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG)
    private var start = 0.0f //初相  正弦函数：y=Asin(ωx+φ)+k
    private var range = 0.0  //周期，决定屏幕范围内波浪的数量
    var cycle = 2    //周期乘数，自定义
    var peakHeight = 8.0f //波浪高度，dp
    var waveColor: Int = Color.WHITE
    var waveAlpha = 80
    var listenr:OnWaveChangeListener?=null


    constructor(context: Context) : super(context)

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        val ta = context.obtainStyledAttributes(attr, R.styleable.SugarWaveView)
        waveColor = ta.getColor(R.styleable.SugarWaveView_waveColor, ContextCompat.getColor(context, R.color.colorPrimaryDark))
        waveAlpha = ta.getInt(R.styleable.SugarWaveView_backWaveAlpha, 80)
        cycle = ta.getInt(R.styleable.SugarWaveView_cycle, 2)
        peakHeight = ta.getDimension(R.styleable.SugarWaveView_peakHeight, 8.0f)
        ta.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        range = cycle * Math.PI / width
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        mAbovePaint.isAntiAlias = true
        mAbovePaint.style = Paint.Style.FILL
        mAbovePaint.color = waveColor
        mBelowPaint.isAntiAlias = true
        mBelowPaint.style = Paint.Style.FILL
        mBelowPaint.color = waveColor
        mBelowPaint.alpha = waveAlpha

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawFilter = drawFilter
        mAbovePath.reset()//每次onDraw前初始化path，above为不透明波浪，below为透明的波浪
        mBelowPath.reset()
        start -= 0.1f//初相
        var y1: Float
        var y2: Float
        mAbovePath.moveTo(left.toFloat(), bottom.toFloat())
        mBelowPath.moveTo(left.toFloat(), bottom.toFloat())
        for (x in 0..width step 20) {//kotlin写法  java为for(int i=0;i<=getWidth();i+=20)
            /**
             * 此处根据X不断变化，算出Y的值，得到正弦、余弦曲线的坐标点，最后一个个连接起来
             */
            y1 = (peakHeight * Math.cos(range * x + start) + peakHeight + 10).toFloat()
            y2 = (peakHeight * Math.sin(range * x + start) + peakHeight).toFloat()
            mAbovePath.lineTo(x.toFloat(), y1)
            mBelowPath.lineTo(x.toFloat(), y2)
        }
        val middleY = (peakHeight * Math.cos(range * width/2 + start) + peakHeight).toFloat()
        listenr?.onWaveHeightChange(middleY)
        mAbovePath.lineTo(right.toFloat(), bottom.toFloat())
        mBelowPath.lineTo(right.toFloat(), bottom.toFloat())
        canvas.drawPath(mAbovePath, mAbovePaint)
        canvas.drawPath(mBelowPath, mBelowPaint)
        postInvalidateDelayed(10)//延迟10ms重新绘制
    }

    interface OnWaveChangeListener{
        fun onWaveHeightChange(y:Float)
    }

}