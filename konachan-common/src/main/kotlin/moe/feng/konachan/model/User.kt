package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class User {

	var name: String = ""
	@SerialName("blacklisted_tags") var blacklistedTags: Array<String> = emptyArray()
	var id: Int = 0

	companion object {

		val LIST_SERIALIZER = User::class.serializer().list

	}

}