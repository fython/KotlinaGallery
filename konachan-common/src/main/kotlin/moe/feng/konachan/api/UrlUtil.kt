package moe.feng.konachan.api

fun toUrlQueryParams(vararg args: Pair<String, Any?>): CharSequence {
	val sb = StringBuilder()
	args.forEach { (key, value) -> if (value != null) sb.append("&$key=$value") }
	return sb.trimStart('&')
}