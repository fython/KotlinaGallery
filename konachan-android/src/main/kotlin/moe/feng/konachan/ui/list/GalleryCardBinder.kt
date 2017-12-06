package moe.feng.konachan.ui.list

import moe.feng.konachan.R
import moe.feng.konachan.databinding.ItemGalleryCardBinding
import moe.feng.konachan.model.Post
import moe.feng.konachan.ui.common.BindingItemViewBinder

class GalleryCardBinder: BindingItemViewBinder<Post, ItemGalleryCardBinding>() {

	override val LAYOUT_RES_ID: Int = R.layout.item_gallery_card

}