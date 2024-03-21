
package io.helidon.examples.quickstart.se;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.logging.common.LogConfig;
import io.helidon.config.Config;
import io.helidon.webclient.api.WebClient;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRouting;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static final String DELAY_QUERY_PARAMETER = "delay";

    private static final List<Product> products;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final WebClient webClient = WebClient.builder()
            .baseUri("http://localhost:8084")
            .build();


    static {
        Product p1 = new Product(1, "Water", "Mineral Water", new BigDecimal(1.75));
        Product p2 = new Product(2, "French Fries", "Medium French Fries", new BigDecimal(3.55));
        Product p3 = new Product(3, "Onion", "Onion Rings", new BigDecimal(5.25));
        Product p4 = new Product(4, "Egg", "Fresh eggs", new BigDecimal(2.75));
        Product p5 = new Product(5, "Coffee", "Black Coffee", new BigDecimal(3.20));
        products = List.of(p1, p2, p3, p4, p5);
    }

    private Main() {
    }

    public static void main(String[] args) {

        // load logging configuration
        LogConfig.configureRuntime();

        // initialize global config from default configuration
        Config config = Config.create();
        Config.global(config);


        WebServer server = WebServer.builder()
                .config(config.get("server"))
                .routing(Main::routing)
                .build()
                .start();


        System.out.println("WEB server is up! http://localhost:" + server.port() + "/simple-greet");

    }

    static void routing(HttpRouting.Builder routing) {
        routing.get("/product", (req, res) -> {
                    final var delayString = req.query().get(DELAY_QUERY_PARAMETER);
                    final var delayInt = Integer.parseInt(delayString);
                    Thread.sleep(delayInt);
                    res.send(objectMapper.writeValueAsBytes(products));
                })
                .get("/performance-helidon", (req, res) -> {
                    final var delayString = req.query().get(DELAY_QUERY_PARAMETER);
                    final var response = webClient.get()
                            .path("/product")
                            .queryParam("delay", delayString)
                            .request(String.class);
                    res.send(response.entity());
                });
    }
}