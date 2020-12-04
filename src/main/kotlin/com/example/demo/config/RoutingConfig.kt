package net.relaxism.devtools.webdevtools.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class RoutingConfig(
    @Autowired private val applicationProperties: ApplicationProperties,
) {

    @Bean
    fun apiRouter() = router {
    }

}
