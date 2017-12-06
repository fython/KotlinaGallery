package moe.feng.konachan.ui.common

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.ViewTreeObserver
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import me.drakeet.multitype.MultiTypeAdapter
import moe.feng.konachan.model.Picture
import moe.feng.konachan.util.ColorGenerator
import moe.feng.konachan.util.TextDrawable
import moe.feng.konachan.util.extension.*
import org.jetbrains.anko.*

object ExtraBindingAdapter: AnkoLogger {

	@BindingAdapter("bind:items")
	@JvmStatic fun setMultiTypeAdapterItems(view: RecyclerView, array: Array<*>?) {
		setMultiTypeAdapterItems(view, array?.toList())
	}

	@BindingAdapter("bind:items")
	@JvmStatic fun setMultiTypeAdapterItems(view: RecyclerView, list: List<*>?) {
		(view.adapter as? MultiTypeAdapter)?.items = list ?: mutableListOf<Any>()
		view.adapter?.notifyDataSetChanged()
	}

	@BindingAdapter("bind:isRefreshing")
	@JvmStatic fun setIsRefreshing(view: SwipeRefreshLayout, boolean: Boolean) {
		view.isRefreshing = boolean
	}

	@BindingAdapter("android:src")
	@JvmStatic fun setImageViewResource(imageView: ImageView, resource: Int) {
		imageView.setImageResource(resource)
	}

	@BindingAdapter("bind:imageUrl")
	@JvmStatic fun setImageViewUrl(imageView: ImageView, url: String?) {
		imageView.setImageDrawable(null)
		if (url != null) {
			async(UI) {
				Picasso.with(imageView.context)
						.load(url)
						.into(imageView, object: Callback {
							override fun onSuccess() { imageView.animateMaterial() }
							override fun onError() {}
						})
			}
		}
	}

	@BindingAdapter("bind:pictureModel")
	@JvmStatic fun setImageViewPicture(imageView: ImageView, pic: Picture?) {
		imageView.setImageDrawable(null)
		if (pic != null) {
			imageView.background = TextDrawable.builder().buildRect(
					"", ColorGenerator.MATERIAL.getColor(pic))
			imageView.viewTreeObserver.addOnGlobalLayoutListener(
					object : ViewTreeObserver.OnGlobalLayoutListener {
						override fun onGlobalLayout() {
							if (pic.height > 0 && pic.width > 0) {
								val width = imageView.measuredWidth
								val height = Math.round(
										width * (pic.height.toDouble() / pic.width)).toInt()
								imageView.layoutParams.height = height
								imageView.minimumHeight = height
							}
							imageView.viewTreeObserver.removeOnGlobalLayoutListener(this)
						}
					}
			)
			async(UI) {
				try {
					Picasso.with(imageView.context)
							.load("https:" + pic.url)
							.into(imageView, object: Callback {
								override fun onSuccess() { imageView.animateMaterial() }
								override fun onError() {}
							})
				} catch (e: Exception) {
					e.printStackTrace()
				}
			}
		}
	}

}