package moe.feng.konachan.util.extension

import android.support.v7.widget.RecyclerView
import moe.feng.konachan.ui.common.OnLoadMoreListener

/**
 * When RecyclerView should load more contents, action will be done.
 *
 * @param action What should be done when it need to load more
 */
fun RecyclerView.setOnLoadMoreListener(action: () -> Unit) {
	this.addOnScrollListener(OnLoadMoreListener(object: OnLoadMoreListener.Callback {
		override fun onLoadMore() {
			action.invoke()
		}
	}))
}