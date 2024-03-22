package com.filipe.performance.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filipe.performance.dto.Product;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final TypeReference<List<Product>> responseType = new TypeReference<>() {
    };

    private final CloseableHttpAsyncClient apacheClient;

    @Autowired
    public ClientController() {
        this.apacheClient = HttpAsyncClients.custom().setMaxConnPerRoute(2000).setMaxConnTotal(2000).build();
        this.apacheClient.start();
    }

    @GetMapping(value = "/performance-mvc")
    public CompletableFuture<List<Product>> getUserUsingApacheHttpClient(@RequestParam long delay) {
        return sendRequestWithApacheHttpClient(delay);
    }

    private CompletableFuture<List<Product>> sendRequestWithApacheHttpClient(long delay) {
        CompletableFuture<org.apache.http.HttpResponse> cf = new CompletableFuture<>();
        FutureCallback<org.apache.http.HttpResponse> callback = new HttpResponseCallback(cf);
        HttpUriRequest request = new HttpGet("http://localhost:8081/product?delay=" + delay);
        apacheClient.execute(request, callback);
        return cf.thenApply(response -> {
            try {
                final var payload = EntityUtils.toString(response.getEntity());
                final var result = OBJECT_MAPPER.readValue(payload, responseType);
                return result;
            } catch (ParseException | IOException e) {
                return null;
            }
        }).exceptionally(e -> null);
    }


    class HttpResponseCallback implements FutureCallback<org.apache.http.HttpResponse> {

        private CompletableFuture<org.apache.http.HttpResponse> cf;

        HttpResponseCallback(CompletableFuture<org.apache.http.HttpResponse> cf) {
            this.cf = cf;
        }

        @Override
        public void failed(Exception ex) {
            cf.completeExceptionally(ex);
        }

        @Override
        public void completed(org.apache.http.HttpResponse result) {
            cf.complete(result);
        }

        @Override
        public void cancelled() {
            cf.completeExceptionally(new Exception("Cancelled by http async client"));
        }
    }
}
    
