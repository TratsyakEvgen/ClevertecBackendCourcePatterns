package ru.clevertec.service.notifier.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.clevertec.model.Product;
import ru.clevertec.service.notifier.NotifierProductObserver;

@Component
@Slf4j
public class SmsNotifierProductObserver implements NotifierProductObserver {
    @Override
    public void notify(Product product) {
        log.info("Send sms");
    }
}
