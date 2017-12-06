package moe.feng.konachan.model

expect class Date() {
	fun getDate(): Int
	fun getMonth(): Int
	fun getFullYear(): Int
	fun getHours(): Int
	fun getMinutes(): Int
	fun getTime(): Number
}

expect fun parseTimestampToDate(timestamp: Number): Date