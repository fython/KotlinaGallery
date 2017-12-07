package moe.feng.konachan.model

import kotlinx.serialization.*

@Serializable class Tag {

	var id: Int = 0
	var name: String = ""
	var count: Int = 0
	var type: Int = TYPE_GENERAL
	@SerialName("ambiguous") var isAmbiguous: Boolean = false

	companion object {
		const val TYPE_GENERAL = 0
		const val TYPE_ARTIST = 1
		const val TYPE_COPYRIGHT = 3
		const val TYPE_CHARACTER = 4

		val LIST_SERIALIZER = Tag::class.serializer().list
	}

}