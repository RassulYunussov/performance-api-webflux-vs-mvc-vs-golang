package com.filipe.performance.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.filipe.performance.dto.Product;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

    private static final ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<>() {
    };
    private final WebClient wc = WebClient.builder()
            .baseUrl("http://localhost:8082")
            .build();

    @GetMapping(value = "/performance-webflux")
    public Mono<List<Product>> getUserUsingWebfluxWebclient(@RequestParam long delay) {
        return wc.get()
                .uri("/product?delay={delay}", delay)
                .retrieve()
                .bodyToMono(responseType);
    }

}

