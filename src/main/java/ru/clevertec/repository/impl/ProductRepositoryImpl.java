package ru.clevertec.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.clevertec.model.Product;
import ru.clevertec.repository.ProductRepository;

@Repository
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public void update(Product product) {
        log.info("Update product " + product);
    }
}
