package moe.feng.konachan.util.extension

import android.support.v7.widget.RecyclerView
import me.drakeet.multitype.ItemViewBinder
import me.drakeet.multitype.MultiTypeAdapter

inline fun <reified T, reified VH: RecyclerView.ViewHolder> MultiTypeAdapter
		.registerOne(binder: ItemViewBinder<T, VH>) = register(T::class.java, binder)