package com.filipe.performance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.performance.dto.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final List<Product> products;

    static {
        Product p1 = new Product(1, "Water", "Mineral Water", 1.75);
        Product p2 = new Product(2, "French Fries", "Medium French Fries", 3.55);
        Product p3 = new Product(3, "Onion", "Onion Rings", 5.25);
        Product p4 = new Product(4, "Egg", "Fresh eggs", 2.75);
        Product p5 = new Product(5, "Coffee", "Black Coffee", 3.20);

        products = List.of(p1, p2, p3, p4, p5);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts(@RequestParam long delay) throws InterruptedException {

        Thread.sleep(delay);

        return products;
    }
}