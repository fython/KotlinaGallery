package moe.feng.konachan.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable data class Picture(
		val url: String,
        val width: Int,
        val height: Int,
        @SerialName("file_size") var fileSize: Long = 0
)