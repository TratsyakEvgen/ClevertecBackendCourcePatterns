package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import ru.clevertec.model.Product;
import ru.clevertec.service.ProductService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    public void create(Product product) {
        log.info("Create new product " + product);
    }

    public void get(long id) {
        log.info("Get product with id " + id);
    }

    public void update(Product product) {
        productService.update(product);
    }

}
