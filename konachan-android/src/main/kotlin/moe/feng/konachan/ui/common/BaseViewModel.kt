package moe.feng.konachan.ui.common

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.AnkoLogger

open class BaseViewModel: AnkoLogger {

	internal fun <T> ui(block: suspend CoroutineScope.() -> T) {
		async(UI) {
			try {
				block()
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}
	}

}