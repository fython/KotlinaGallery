package moe.feng.konachan.api

import kotlinx.coroutines.experimental.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.*
import moe.feng.konachan.model.*
import java.net.URL

actual object KonachanApi: BaseApi {

	suspend override fun getPost(page: Int, limit: Int, tags: String?, safeMode: Boolean): List<Post>? =
			getPostUrl(page, limit, tags, safeMode).requestList()

	suspend override fun getTags(page: Int?, limit: Int?, order: BaseApi.Order?, id: Int?, afterId: Int?,
	                             name: String?, namePattern: String?, safeMode: Boolean): List<Tag>? =
			getTagsUrl(page, limit, order, id, afterId, name, namePattern, safeMode).requestList()

	suspend override fun getArtists(name: String?, order: BaseApi.Order?, page: Int?,
	                                safeMode: Boolean): List<Artist>? =
			getArtistsUrl(name, order, page, safeMode).requestList()

	suspend override fun getComments(id: Int, safeMode: Boolean): List<Comment>? =
			getCommentsUrl(id, safeMode).requestList()

	suspend override fun getWiki(page: Int?, order: BaseApi.Order?, limit: Int?,
	                             query: String?, safeMode: Boolean): List<Wiki>? =
			getWikiUrl(page, order, limit, query, safeMode).requestList()

	suspend override fun getNotes(postId: Int, safeMode: Boolean): List<Note>? =
			getNotesUrl(postId, safeMode).requestList()

	suspend override fun searchUser(id: Int?, name: String?, safeMode: Boolean): List<User>? =
			searchUserUrl(id, name, safeMode).requestList()

	suspend override fun getForums(parentId: Int?, safeMode: Boolean): List<Forum>? =
			getForumsUrl(parentId, safeMode).requestList()

	suspend override fun getPools(query: String?, page: Int?, safeMode: Boolean): List<Pool>? =
			getPoolsUrl(query, page, safeMode).requestList()

	suspend override fun showPool(id: Int, page: Int?, safeMode: Boolean): Pool? =
			showPoolUrl(id, page, safeMode).requestObject()

	fun getPostAsync(page: Int = 1, limit: Int = 1, tags: String? = null,
	                 safeMode: Boolean = true): Deferred<List<Post>?> =
			async(CommonPool) { getPost(page, limit, tags, safeMode) }

	fun getTagsAsync(page: Int? = null, limit: Int? = null, order: BaseApi.Order? = null,
	                 id: Int? = null, afterId: Int? = null, name: String? = null,
	                 namePattern: String? = null, safeMode: Boolean = true): Deferred<List<Tag>?> =
			async(CommonPool) { getTags(page, limit, order, id, afterId, name, namePattern, safeMode) }

	fun getArtistsAsync(name: String? = null, order: BaseApi.Order? = null, page: Int? = null,
	                    safeMode: Boolean = true): Deferred<List<Artist>?> =
			async(CommonPool) { getArtists(name, order, page, safeMode) }

	private inline suspend fun <reified T: Any> String.requestObject(): T
			= JSON.nonstrict.parse(URL(this).readText())

	private inline suspend fun <reified T: Any> String.requestList(): List<T>
			= JSON.nonstrict.parse(T::class.serializer().list, URL(this).readText())

}