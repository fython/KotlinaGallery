package moe.feng.konachan.ui.main

import android.os.Bundle
import me.drakeet.multitype.MultiTypeAdapter
import moe.feng.konachan.R
import moe.feng.konachan.databinding.ActivityMainBinding
import moe.feng.konachan.ui.common.BindingActivity
import moe.feng.konachan.ui.list.GalleryCardBinder
import moe.feng.konachan.util.extension.registerOne
import moe.feng.konachan.util.extension.setOnLoadMoreListener

class MainActivity : BindingActivity<ActivityMainBinding>() {

	override val LAYOUT_RES_ID: Int = R.layout.activity_main

	private val mainViewModel: MainViewModel = MainViewModel()

	override fun onViewCreated(savedInstanceState: Bundle?) {
		binding.viewModel = mainViewModel
		binding.init()

		mainViewModel.onRefresh()
	}

	private fun ActivityMainBinding.init() {
		galleryList.adapter = MultiTypeAdapter().apply { registerOne(GalleryCardBinder()) }

		swipeRefreshLayout.setOnRefreshListener(mainViewModel::onRefresh)
		galleryList.setOnLoadMoreListener(mainViewModel::loadNextPage)
	}

}
