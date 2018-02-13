package com.wulei.sugardemo.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.wulei.base.activity.BaseBindingActivity
import com.wulei.sugardemo.R
import com.wulei.sugardemo.databinding.ActivityWaveviewBinding
import com.wulei.sugardemo.vm.WaveVm
import com.wulei.uikit.SugarWaveView
import kotlinx.android.synthetic.main.activity_waveview.*

/**
 * Created by wulei on 2018/2/13.
 */
class WaveViewActivity : BaseBindingActivity() {

    private lateinit var binding: ActivityWaveviewBinding
    private lateinit var model: WaveVm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        waveview.listenr = object : SugarWaveView.OnWaveChangeListener {
            override fun onWaveHeightChange(y: Float) {
                model.avatarMargin.set((y + 2).toInt())
            }
        }
    }


    override fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_waveview)
        model = WaveVm()
        binding.model = model
    }

}