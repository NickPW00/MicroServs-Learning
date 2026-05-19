package com.example.user_service.config;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

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
