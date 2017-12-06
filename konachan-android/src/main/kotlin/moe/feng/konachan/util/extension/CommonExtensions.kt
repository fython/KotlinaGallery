package moe.feng.konachan.util.extension

import kotlin.reflect.KFunction

inline fun <reified OBJ, reified RESULT> OBJ.tryRun(method: OBJ.() -> RESULT): RESULT? =
		try {
			method(this)
		} catch (e: Exception) {
			e.printStackTrace()
			null
		}

inline fun <reified METHOD: KFunction<RESULT>, reified RESULT>
		METHOD.tryCall(vararg args: Any?): RESULT? =
		try {
			this.call(*args)
		} catch (e: Exception) {
			e.printStackTrace()
			null
		}

private val BRACKETS = arrayOf("[",  "]", "{", "}", "(", ")", ",", ".",
		"<", ">", "《", "》", "【", "】", "｛", "｝")

fun String.firstWord(): String? =
		(0 until length).map { substring(it, it + 1) }.firstOrNull { it !in BRACKETS }
