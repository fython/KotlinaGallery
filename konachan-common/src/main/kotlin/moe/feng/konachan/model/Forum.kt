package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Forum {

	var body: String = ""
	var creator: String = ""
	@SerialName("creator_id") var creatorId: Int = 0
	var id: Int = 0
	@SerialName("parent_id") var parentId: Int? = null
	var title: String = ""
	@SerialName("updated_at") var updatedAt: String = ""
	var pages: Int = 0

	companion object {

		val LIST_SERIALIZER = Forum::class.serializer().list

	}

}