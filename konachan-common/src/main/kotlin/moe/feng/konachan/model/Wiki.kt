package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Wiki {

	var id: Int = 0
	@SerialName("created_at") var createdAt: String = ""
	@SerialName("updated_at") var updatedAt: String = ""
	var title: String = ""
	var body: String = ""
	@SerialName("updater_id") var updaterId: Int = 0
	@SerialName("locked") var isLocked: Boolean = false
	var version: Int = 0

	companion object {

		val LIST_SERIALIZER = Wiki::class.serializer().list

	}

}