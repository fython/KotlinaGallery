package moe.feng.konachan.ui.common

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

abstract class BindingActivity<T: ViewDataBinding>: BaseActivity() {

	abstract val LAYOUT_RES_ID: Int

	internal lateinit var binding: T

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, LAYOUT_RES_ID)
		onViewCreated(savedInstanceState)
	}

	abstract fun onViewCreated(savedInstanceState: Bundle?)

}