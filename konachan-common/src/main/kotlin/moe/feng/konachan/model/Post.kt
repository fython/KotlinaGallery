package moe.feng.konachan.model

import kotlinx.serialization.*
import kotlin.math.max

@Serializable class Post {

	var id: Int = 0
	var tags: String? = null
	@SerialName("created_at") var createdAt: Long = 0L
	@SerialName("creator_id") var creatorId: Long = 0L
	var author: String? = null
	var change: Long = 0L
	var source: String? = null
	var score: Int = 0
	var md5: String? = null
	@SerialName("file_size") var fileSize: Long = 0L
	@SerialName("file_url") var fileUrl: String = ""
	@SerialName("is_shown_in_index") var isShownInIndex: Boolean = false
	@SerialName("preview_url") var previewUrl: String = ""
	@SerialName("preview_width") var previewWidth: Int = 0
	@SerialName("preview_height") var previewHeight: Int = 0
	@SerialName("actual_preview_width") var actualPreviewWidth: Int = 0
	@SerialName("actual_preview_height") var actualPreviewHeight: Int = 0
	@SerialName("sample_url") var sampleUrl: String = ""
	@SerialName("sample_width") var sampleWidth: Int = 0
	@SerialName("sample_height") var sampleHeight: Int = 0
	@SerialName("sample_file_size") var sampleFileSize: Long = 0L
	@SerialName("jpeg_url") var jpegUrl: String = ""
	@SerialName("jpeg_width") var jpegWidth: Int = 0
	@SerialName("jpeg_height") var jpegHeight: Int = 0
	@SerialName("jpeg_file_size") var jpegFileSize: Long = 0L
	var rating: String = "s"
	@SerialName("has_children") var hasChildren: Boolean = false
	@SerialName("parent_id") var parentId: Long? = null
	var status: String = "active"
	var width: Int = 0
	var height: Int = 0
	@SerialName("is_held") var isHeld: Boolean = false

	/*@SerialName("frames_pending_string") var framesPendingString: String = ""
	@SerialName("frames_pending") var framesPending: Array<Any> = emptyArray()
	@SerialName("frames_string") var framesString: String = ""
	var frames: Array<Any> = emptyArray()*/

	fun getPictureRatio(): Float = width.toFloat() / max(1F, height.toFloat())
	fun getTags(): Array<String> = tags?.split(" ")?.toTypedArray() ?: emptyArray()
	fun getCreatedAtDate(): Date = parseTimestampToDate(createdAt)

	fun getPreviewPic() = Picture(previewUrl, previewWidth, previewHeight)
	fun getSamplePic() = Picture(sampleUrl, sampleWidth, sampleHeight, sampleFileSize)
	fun getJpegPic() = Picture(jpegUrl, jpegWidth, jpegHeight, jpegFileSize)

}

val postListSerializer: KSerializer<List<Post>> = Post::class.serializer().list