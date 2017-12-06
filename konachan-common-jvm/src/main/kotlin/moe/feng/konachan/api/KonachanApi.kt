package moe.feng.konachan.api

import kotlinx.coroutines.experimental.*
import kotlinx.serialization.json.JSON
import moe.feng.konachan.model.*
import java.net.URL

actual object KonachanApi: BaseApi {

	suspend override fun getPost(page: Int, limit: Int, tags: String?, safeMode: Boolean): List<Post>? =
			JSON.nonstrict.parse(postListSerializer, URL(getPostUrl(page, limit, tags, safeMode)).readText())

	fun getPostAsync(page: Int = 1, limit: Int = 1, tags: String? = null, safeMode: Boolean = true): Deferred<List<Post>?> =
			async(CommonPool) { getPost(page, limit, tags, safeMode) }

	suspend override fun getTags(page: Int?, limit: Int?, order: BaseApi.Order?, id: Int?, afterId: Int?,
	                             name: String?, namePattern: String?, safeMode: Boolean): List<Tag>? =
			JSON.nonstrict.parse(tagsListSerializer,
					URL(getTagsUrl(page, limit, order, id, afterId, name, namePattern, safeMode)).readText())

	fun getTagsAsync(page: Int? = null, limit: Int? = null, order: BaseApi.Order? = null,
	                 id: Int? = null, afterId: Int? = null, name: String? = null,
	                 namePattern: String? = null, safeMode: Boolean = true): Deferred<List<Tag>?> =
			async(CommonPool) { getTags(page, limit, order, id, afterId, name, namePattern, safeMode) }

	suspend override fun getArtists(name: String?, order: BaseApi.Order?, page: Int?,
	                                safeMode: Boolean): List<Artist>? =
			JSON.nonstrict.parse(artistsListSerializer, URL(getArtistsUrl(name, order, page, safeMode)).readText())

	fun getArtistsAsync(name: String? = null, order: BaseApi.Order? = null, page: Int? = null,
	                    safeMode: Boolean = true): Deferred<List<Artist>?> =
			async(CommonPool) { getArtists(name, order, page, safeMode) }

}