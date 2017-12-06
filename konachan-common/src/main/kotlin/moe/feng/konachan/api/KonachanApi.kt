package moe.feng.konachan.api

expect object KonachanApi: BaseApi

const val KONACHAN_COM_HOST = "https://konachan.com"
const val KONACHAN_NET_HOST = "https://konachan.net"

fun KonachanApi.getPostUrl(page: Int, limit: Int, tags: String?, safeMode: Boolean): String =
		"${if (safeMode) KONACHAN_NET_HOST else KONACHAN_COM_HOST}/post.json?" +
				toUrlQueryParams("page" to page, "limit" to limit, "tags" to tags)

fun KonachanApi.getTagsUrl(page: Int?, limit: Int?, order: BaseApi.Order?, id: Int?,
                           afterId: Int?, name: String?, namePattern: String?, safeMode: Boolean): String =
		"${if (safeMode) KONACHAN_NET_HOST else KONACHAN_COM_HOST}/tag.json?" +
				toUrlQueryParams("page" to page, "limit" to limit, "order" to order?.order, "id" to id,
						"after_id" to id, "name" to name, "name_pattern" to namePattern)

fun KonachanApi.getArtistsUrl(name: String?, order: BaseApi.Order?, page: Int?, safeMode: Boolean): String =
		"${if (safeMode) KONACHAN_NET_HOST else KONACHAN_COM_HOST}/artist.json?" +
				toUrlQueryParams("page" to page, "order" to order?.order, "name" to name)