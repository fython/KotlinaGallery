package moe.feng.konachan.api

import moe.feng.konachan.model.*

interface BaseApi {

	suspend fun getPost(page: Int = 1, limit: Int = 1, tags: String? = null, safeMode: Boolean = true): List<Post>?

	suspend fun getTags(page: Int? = null, limit: Int? = null, order: Order? = null, id: Int? = null,
	                    afterId: Int? = null, name: String? = null,
	                    namePattern: String? = null, safeMode: Boolean = true): List<Tag>?

	suspend fun getArtists(name: String? = null, order: Order? = null, page: Int? = null,
	                       safeMode: Boolean = true): List<Artist>?

	enum class Order(val order: String) {
		DATE("date"), COUNT("count"), NAME("name")
	}

}