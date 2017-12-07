package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Comment {

	var id: Int = 0
	@SerialName("created_at") var createdAt: String = ""
	@SerialName("post_id") var postId: Int = 0
	var creator: String = ""
	@SerialName("creator_id") var creatorId: Int = 0
	var body: String = ""

	companion object {

		val LIST_SERIALIZER = Comment::class.serializer().list

	}

}