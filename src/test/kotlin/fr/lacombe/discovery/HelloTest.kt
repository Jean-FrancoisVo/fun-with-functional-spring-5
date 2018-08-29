package fr.lacombe.discovery

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.support.GenericApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient

class HelloTest {
    private val context = GenericApplicationContext().apply {
        beans().initialize(this)
        refresh()
    }
    private val client = WebTestClient.bindToRouterFunction(context.getBean<HelloRoutes>(HelloRoutes::class).router())
            .build()
    private val mapper = jacksonObjectMapper()


    @Test
    fun `Route should return ok and expected body`() {
        val expected = mapper.writeValueAsString(mapOf("hello" to "world"))
        client.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk
                .expectBody().json(expected)
    }
}
