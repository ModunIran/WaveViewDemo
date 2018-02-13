package com.wulei.sugardemo.view.activity

import android.databinding.DataBindingUtil
import com.wulei.base.activity.BaseBindingActivity
import com.wulei.sugardemo.R
import com.wulei.sugardemo.databinding.ActivityMainBinding
import com.wulei.sugardemo.vm.MainVm
import org.jetbrains.anko.startActivity

class MainActivity : BaseBindingActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainVm
    private lateinit var listener: Listener

    override fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        model = MainVm()
        listener = Listener()
        binding.model = model
        binding.listener = listener
    }

    private inner class Listener : MainVm.Listener {
        override fun onWaveClick() {
            startActivity<WaveViewActivity>()
        }

    }
}
