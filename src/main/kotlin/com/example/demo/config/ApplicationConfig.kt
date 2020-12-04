package net.relaxism.devtools.webdevtools.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@EnableConfigurationProperties(ApplicationProperties::class)
class ApplicationConfiguration {

    @Bean
    fun webClient(): WebClient = WebClient.builder().build();

}

@ConstructorBinding
@ConfigurationProperties(prefix = "application")
data class ApplicationProperties(
    val apiBasePath: String,
    val indexFile: Resource,
    val cors: CorsProperties,
) {

    data class CorsProperties(
        val mappingPathPattern: String,
        val allowedOrigins: List<String>,
        val allowedMethods: List<String>,
        val maxAge: Long
    )

}

