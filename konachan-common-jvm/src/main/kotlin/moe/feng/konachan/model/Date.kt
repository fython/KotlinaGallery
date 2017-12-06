package moe.feng.konachan.model

import java.util.*
import java.util.Calendar.*

actual class Date {
	private val calendar: Calendar

	actual constructor() {
		calendar = Calendar.getInstance()
	}

	constructor(date: java.util.Date) {
		calendar = Calendar.getInstance().apply {
			time = date
		}
	}

	val date: java.util.Date get() = calendar.time

	actual fun getDate() = calendar[DAY_OF_MONTH]
	actual fun getMonth() = calendar[MONTH]
	actual fun getFullYear() = calendar[YEAR]
	actual fun getHours() = calendar[HOUR_OF_DAY]
	actual fun getMinutes() = calendar[MINUTE]
	actual fun getTime(): Number = calendar.timeInMillis

	override fun equals(other: Any?): Boolean = other is Date && other.calendar.time == calendar.time
}

actual fun parseTimestampToDate(timestamp: Number): Date = Date(java.util.Date().apply { time = timestamp.toLong() })