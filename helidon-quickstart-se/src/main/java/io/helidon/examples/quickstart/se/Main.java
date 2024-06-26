
package io.helidon.examples.quickstart.se;

import io.helidon.common.GenericType;
import io.helidon.http.Status;
import io.helidon.logging.common.LogConfig;
import io.helidon.config.Config;
import io.helidon.webclient.api.WebClient;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRouting;

import java.util.List;

public class Main {

    private static final String DELAY_QUERY_PARAMETER = "delay";

    private static final List<Product> products;

    private static final GenericType<List<Product>> responseType = new GenericType<>() {
    };
    private static final WebClient webClient = WebClient.builder()
            .baseUri("http://localhost:8084")
            .build();


    static {
        Product p1 = new Product(1, "Water", "Mineral Water", 1.75);
        Product p2 = new Product(2, "French Fries", "Medium French Fries", 3.55);
        Product p3 = new Product(3, "Onion", "Onion Rings", 5.25);
        Product p4 = new Product(4, "Egg", "Fresh eggs", 2.75);
        Product p5 = new Product(5, "Coffee", "Black Coffee", 3.20);
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
                    res.send(products);
                })
                .get("/performance-helidon", (req, res) -> {
                    final var delayString = req.query().get(DELAY_QUERY_PARAMETER);
                    try (final var response = webClient.get()
                            .path("/product")
                            .queryParam(DELAY_QUERY_PARAMETER, delayString)
                            .request()) {
                        res.send(response.entity().as(responseType));
                    } catch (RuntimeException e) {
                        res.status(Status.INTERNAL_SERVER_ERROR_500);
                        res.send();
                    }
                });
    }
}