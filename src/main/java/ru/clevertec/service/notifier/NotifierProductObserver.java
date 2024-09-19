package ru.clevertec.service.notifier;

import ru.clevertec.model.Product;

public interface NotifierProductObserver {
    void notify(Product product);
}
