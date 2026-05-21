package com.example.cart_service.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Configuration
public class WebClientConfig {

    @Bean
    @Qualifier("userWebClient")
    public WebClient userWebClient(
            @Value("${user-service.url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(ExchangeFilterFunction.ofResponseProcessor(response -> {
                    if (response.statusCode().is4xxClientError()) {
                        return Mono.error(new RuntimeException("User Service retornou erro: "
                                + response.statusCode()));
                    }
                    return Mono.just(response);
                }))
                .build();
    }

    @Bean
    @Qualifier("productWebClient")
    public WebClient productWebClient(
            @Value("${product-service.url}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(ExchangeFilterFunction.ofResponseProcessor(response -> {
                    if (response.statusCode().is4xxClientError()) {
                        return Mono.error(new RuntimeException("Product Service retornou erro: "
                                + response.statusCode()));
                    }
                    return Mono.just(response);
                }))
                .build();
    }
}

