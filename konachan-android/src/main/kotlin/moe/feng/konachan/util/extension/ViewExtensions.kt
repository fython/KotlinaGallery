package moe.feng.konachan.util.extension

import android.widget.ImageView
import com.github.florent37.materialimageloading.MaterialImageLoading

private const val MATERIAL_ANIMATION_DURATION = 800

fun ImageView.animateMaterial()
		= MaterialImageLoading.animate(this).setDuration(MATERIAL_ANIMATION_DURATION).start()