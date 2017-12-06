package moe.feng.konachan.api

import moe.feng.konachan.model.*

actual object KonachanApi: BaseApi {

	suspend override fun getPost(page: Int, limit: Int, tags: String?, safeMode: Boolean): List<Post>? =
			JSON.parse(httpGet(getPostUrl(page, limit, tags, safeMode)))

	suspend override fun getTags(page: Int?, limit: Int?, order: BaseApi.Order?, id: Int?, afterId: Int?,
	                             name: String?, namePattern: String?, safeMode: Boolean): List<Tag>? =
			JSON.parse(httpGet(getTagsUrl(page, limit, order, id, afterId, name, namePattern, safeMode)))

	suspend override fun getArtists(name: String?, order: BaseApi.Order?, page: Int?,
	                                safeMode: Boolean): List<Artist>? =
			JSON.parse(httpGet(getArtistsUrl(name, order, page, safeMode)))

}