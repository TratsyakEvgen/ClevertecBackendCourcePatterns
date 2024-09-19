package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.config.Log;
import ru.clevertec.model.Product;
import ru.clevertec.repository.ProductRepository;
import ru.clevertec.service.ProductService;
import ru.clevertec.service.notifier.NotifierProductObserver;
import ru.clevertec.validator.Validator;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final Validator validator;
    private final ProductRepository productRepository;
    private final List<NotifierProductObserver> notifierProductObservers;

    @Log
    @Override
    public void update(Product product) {
        validator.validate(product);
        productRepository.update(product);
        notifierProductObservers.forEach(notifierProductObserver -> notifierProductObserver.notify(product));
    }
}
