package fr.lacombe.discovery

import org.springframework.web.reactive.function.server.router

class HelloRoutes(
        private val helloHandler: HelloHandler
) {
    fun router() = router {
        GET("/hello", helloHandler::getHello)
    }
}
