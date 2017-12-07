package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Artist {

	var id: Int = 0
	var name: String = ""
	@SerialName("alias_id") var aliasId: Int? = null
	@SerialName("group_id") var groupId: Int? = null
	var urls: Array<String> = emptyArray()

	companion object {

		val LIST_SERIALIZER = Artist::class.serializer().list

	}

}