package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Pool {

	var id: Int = 0
	var name: String = ""
	@SerialName("created_at") var createdAt: String = ""
	@SerialName("updated_at") var updatedAt: String = ""
	@SerialName("user_id") var userId: Int = 0
	@SerialName("is_public") var isPublic: Boolean = true
	@SerialName("post_count") var postCount: Int = 0
	var description: String = ""
	@Optional var posts: Array<Post> = emptyArray()

	companion object {

		val LIST_SERIALIZER = Pool::class.serializer().list

	}

}