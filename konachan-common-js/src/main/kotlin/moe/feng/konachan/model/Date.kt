package moe.feng.konachan.model

actual external class Date {
	actual constructor()
	constructor(value: Number)

	actual fun getDate(): Int
	actual fun getMonth(): Int
	actual fun getFullYear(): Int
	actual fun getHours(): Int
	actual fun getMinutes(): Int
	actual fun getTime(): Number
}

actual fun parseTimestampToDate(timestamp: Number): Date = Date(timestamp)