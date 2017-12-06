package moe.feng.konachan.ui.main

import android.databinding.ObservableField
import moe.feng.konachan.api.KonachanApi
import moe.feng.konachan.model.Post
import moe.feng.konachan.ui.common.BaseViewModel

class MainViewModel: BaseViewModel() {

	val items = ObservableField<MutableList<Post>>(mutableListOf())
	val isRefreshing = ObservableField(false)
	val currentPage = ObservableField(1)

	fun onRefresh() = ui {
		if (!isRefreshing.get()) {
			isRefreshing.set(true)

			val result = KonachanApi.getPostAsync(
					1, limit = 40, tags = "rating:s").await()
			if (result?.isNotEmpty() == true) {
				items.set(result.toMutableList())
				currentPage.set(1)
			} else {
				error("Api error.")
			}

			isRefreshing.set(false)
		}
	}

	@Synchronized fun loadNextPage() = ui {
		if (!isRefreshing.get()) {
			isRefreshing.set(true)

			val result = KonachanApi.getPostAsync(
					currentPage.get() + 1, limit = 40, tags = "rating:s").await()
			if (result?.isNotEmpty() == true) {
				items.set((items.get() + result).toMutableList())
				currentPage.set(currentPage.get() + 1)
			} else {
				error("Api error.")
			}

			isRefreshing.set(false)
		}
	}

}