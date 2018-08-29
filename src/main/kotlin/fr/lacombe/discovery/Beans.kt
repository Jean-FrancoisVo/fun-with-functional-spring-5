package fr.lacombe.discovery

import org.springframework.context.support.beans
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.reactive.function.server.RouterFunctions

fun beans() = beans {
    bean<HelloHandler>()
    bean<HelloRoutes>()
    bean("webHandler") {
        RouterFunctions.toWebHandler(
                ref<HelloRoutes>().router()
        )
    }
    bean("corsFilter") {
        CorsWebFilter { CorsConfiguration().applyPermitDefaultValues() }
    }
}