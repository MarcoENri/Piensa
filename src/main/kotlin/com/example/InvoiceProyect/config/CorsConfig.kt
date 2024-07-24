package com.example.InvoiceProyect.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean

@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:5173") // Cambia esto al origen de tu frontend
        configuration.allowedMethods = listOf("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        configuration.allowCredentials = true
        configuration.allowedHeaders = listOf("*")
        configuration.exposedHeaders = listOf("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    @Bean
    fun corsFilter(): FilterRegistrationBean<CorsFilter> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowedOrigins = listOf("http://localhost:5173")
        config.allowedMethods = listOf("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        config.allowCredentials = true
        config.allowedHeaders = listOf("*")
        config.exposedHeaders = listOf("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        source.registerCorsConfiguration("/**", config)

        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.order = 0
        return bean
    }
}
