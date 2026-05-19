package com.example.user_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

// WebClientConfig.java
// WebClientConfig.java
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient productWebClient(
            @Value("${product-service.url}") String baseUrl) {

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
