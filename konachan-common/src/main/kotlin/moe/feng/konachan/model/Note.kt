package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Note {

	var id: Int = 0
	@SerialName("created_at") var createdAt: String = ""
	@SerialName("updated_at") var updatedAt: String = ""
	@SerialName("creator_id") var creatorId: Int = 0
	var x: Int = 0
	var y: Int = 0
	var width: Int = 0
	var height: Int = 0
	@SerialName("is_active") var isActive: Boolean = true
	@SerialName("post_id") var postId: Int = 0
	var body: String = ""
	var version: Int = 0

	companion object {

		val LIST_SERIALIZER = Note::class.serializer().list

	}

}