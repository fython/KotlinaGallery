package moe.feng.konachan

import kotlinx.serialization.json.JSON
import moe.feng.konachan.api.KonachanApi
import moe.feng.konachan.api.async
import moe.feng.konachan.model.postListSerializer
import kotlin.test.Test

class ApiTest {

	@Test
	fun testGetPost() {
		async { KonachanApi.getPost(1, 1, null, true) }.then { latestPost ->
			if (latestPost != null) {
				println("Result: " + JSON().stringify(postListSerializer, latestPost))
			} else {
				println("Api error.")
			}
		}
	}

}