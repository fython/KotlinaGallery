package moe.feng.konachan.api

import moe.feng.konachan.model.*

/**
 * BaseApi defines what interface needs in API object
 * <p>
 * Chinese translation:
 * BaseApi 定义了 API 对象中需要哪些接口
 *
 * @author Fung Gwo (fython)
 */
interface BaseApi {

	/**
	 * Get posts
	 *
	 * @param page The page number.
	 * @param limit How many posts you want to retrieve. There is a hard limit of 100 posts per request.
	 * @param tags The tags to search for. Any tag combination that works on the web site will work here. This includes all the meta-tags.
	 * @param safeMode If allowed show NSFW contents
	 * @return Posts list
	 * @See Post
	 */
	suspend fun getPost(
			page: Int = 1, limit: Int = 1,
			tags: String? = null, safeMode: Boolean = true
	): List<Post>?


	/**
	 * Get tags
	 *
	 * @param page
	 * @param limit
	 * @param order
	 * @param id
	 * @param afterId
	 * @param name
	 * @param namePattern
	 * @param safeMode
	 * @return Tags list
	 * @see Tag
	 * @see Order
	 */
	suspend fun getTags(
			page: Int? = null, limit: Int? = null, order: Order? = null, id: Int? = null,
			afterId: Int? = null, name: String? = null, namePattern: String? = null,
			safeMode: Boolean = true
	): List<Tag>?


	/**
	 * Get artists
	 *
	 * @param name
	 * @param order
	 * @param page
	 * @param safeMode
	 * @return Artists list
	 * @see Artist
	 * @see Order
	 */
	suspend fun getArtists(
			name: String? = null, order: Order? = null, page: Int? = null,
			safeMode: Boolean = true
	): List<Artist>?


	/**
	 * Get comments in specific post
	 *
	 * @param id
	 * @param safeMode
	 * @return Comments list in specific post
	 * @see Comment
	 */
	suspend fun getComments(
			id: Int, safeMode: Boolean = true
	): List<Comment>?


	/**
	 * Get wiki
	 *
	 * @param page
	 * @param order
	 * @param limit
	 * @param query
	 * @param safeMode
	 * @return Wiki list
	 * @see Wiki
	 * @see Order
	 */
	suspend fun getWiki(
			page: Int? = null, order: Order? = null,
			limit: Int? = null, query: String? = null, safeMode: Boolean = true
	): List<Wiki>?


	/**
	 * Get notes in specific post
	 *
	 * @param postId
	 * @param safeMode
	 * @return Notes list in specific post
	 * @see Note
	 */
	suspend fun getNotes(
			postId: Int, safeMode: Boolean = true
	): List<Note>?


	/**
	 * Search user by id or name
	 *
	 * @param id
	 * @param name
	 * @param safeMode
	 * @return Users result
	 * @see User
	 */
	suspend fun searchUser(
			id: Int? = null, name: String? = null, safeMode: Boolean = true
	): List<User>?

	/**
	 * Get forums
	 *
	 * @param parentId
	 * @param safeMode
	 * @return Forums list
	 * @see Forum
	 */
	suspend fun getForums(
			parentId: Int? = null, safeMode: Boolean = true
	): List<Forum>?

	/**
	 * Get pools
	 *
	 * @param page
	 * @param query
	 * @return Pools list
	 * @see Pool
	 */
	suspend fun getPools(
			query: String? = null, page: Int? = null, safeMode: Boolean = true
	): List<Pool>?

	/**
	 * Show pools
	 *
	 * @param id
	 * @param page
	 * @param safeMode
	 * @return Pool full data
	 * @see Pool
	 */
	suspend fun showPool(
			id: Int, page: Int? = null, safeMode: Boolean = true
	): Pool?

	enum class Order(val order: String) {
		DATE("date"), COUNT("count"), NAME("name")
	}

}