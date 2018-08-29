package fr.lacombe.discovery

fun beans() = org.springframework.context.support.beans {
    bean<HelloHandler>()
    bean<HelloRoutes>()
}