package moe.feng.konachan

import kotlinx.coroutines.experimental.runBlocking
import kotlinx.serialization.json.JSON
import moe.feng.konachan.api.*
import moe.feng.konachan.model.Artist
import moe.feng.konachan.model.Post
import moe.feng.konachan.model.Tag
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
				println("Result: " + JSON().stringify(Post.LIST_SERIALIZER, latestPost))
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
				println("Result: " + JSON().stringify(Tag.LIST_SERIALIZER, tags))
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
				println("Result: " + JSON().stringify(Artist.LIST_SERIALIZER, artists))
			} else {
				println("Api error.")
			}
		}
	}

}