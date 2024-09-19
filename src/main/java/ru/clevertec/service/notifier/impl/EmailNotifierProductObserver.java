package ru.clevertec.service.notifier.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ru.clevertec.model.Product;
import ru.clevertec.service.notifier.NotifierProductObserver;

@Component
@RequiredArgsConstructor
public class EmailNotifierProductObserver implements NotifierProductObserver {
    private final JavaMailSender mailSender;

    @Override
    public void notify(Product product) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tanchik776@gmail.com");
        message.setTo("tanchik776@gmail.com");
        message.setSubject("Product update");
        message.setText(product.getDescription());
        mailSender.send(message);
    }
}
