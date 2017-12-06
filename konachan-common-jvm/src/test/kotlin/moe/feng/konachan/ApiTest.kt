package moe.feng.konachan

import kotlinx.coroutines.experimental.runBlocking
import kotlinx.serialization.json.JSON
import moe.feng.konachan.api.*
import moe.feng.konachan.model.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiTest {

	@Test
	fun testGetPost() {
		runBlocking {
			val latestPost = KonachanApi.getPost(1, 1, null, true)
			if (latestPost != null) {
				println("Result: " + JSON().stringify(postListSerializer, latestPost))
			} else {
				println("Api error.")
			}
		}
	}

	@Test
	fun testGetTags() {
		runBlocking {
			val tags = KonachanApi.getTags(order = BaseApi.Order.COUNT)
			if (tags != null) {
				println("Result: " + JSON().stringify(tagsListSerializer, tags))
			} else {
				println("Api error.")
			}
		}
	}

	@Test
	fun testGetArtists() {
		runBlocking {
			val artists = KonachanApi.getArtists()
			if (artists != null) {
				println("Result: " + JSON().stringify(artistsListSerializer, artists))
			} else {
				println("Api error.")
			}
		}
	}

}