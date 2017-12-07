package moe.feng.konachan.api

import moe.feng.konachan.model.*

actual object KonachanApi: BaseApi {

	suspend override fun getPost(page: Int, limit: Int, tags: String?, safeMode: Boolean): List<Post>? =
			getPostUrl(page, limit, tags, safeMode).requestObject()

	suspend override fun getTags(page: Int?, limit: Int?, order: BaseApi.Order?, id: Int?, afterId: Int?,
	                             name: String?, namePattern: String?, safeMode: Boolean): List<Tag>? =
			getTagsUrl(page, limit, order, id, afterId, name, namePattern, safeMode).requestObject()

	suspend override fun getArtists(name: String?, order: BaseApi.Order?, page: Int?,
	                                safeMode: Boolean): List<Artist>? =
			getArtistsUrl(name, order, page, safeMode).requestObject()

	suspend override fun getComments(id: Int, safeMode: Boolean): List<Comment>? =
			getCommentsUrl(id, safeMode).requestObject()

	suspend override fun getWiki(page: Int?, order: BaseApi.Order?, limit: Int?,
	                             query: String?, safeMode: Boolean): List<Wiki>? =
			getWikiUrl(page, order, limit, query, safeMode).requestObject()

	suspend override fun getNotes(postId: Int, safeMode: Boolean): List<Note>? =
			getNotesUrl(postId, safeMode).requestObject()

	suspend override fun searchUser(id: Int?, name: String?, safeMode: Boolean): List<User>? =
			searchUserUrl(id, name, safeMode).requestObject()

	suspend override fun getForums(parentId: Int?, safeMode: Boolean): List<Forum>? =
			getForumsUrl(parentId, safeMode).requestObject()

	suspend override fun getPools(query: String?, page: Int?, safeMode: Boolean): List<Pool>? =
			getPoolsUrl(query, page, safeMode).requestObject()

	suspend override fun showPool(id: Int, page: Int?, safeMode: Boolean): Pool? =
			showPoolUrl(id, page, safeMode).requestObject()

	private inline suspend fun <reified T> String.requestObject(): T = JSON.parse(httpGet(this))

}