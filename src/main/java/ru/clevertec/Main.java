package ru.clevertec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.clevertec.model.Product;
import ru.clevertec.model.User;
import ru.clevertec.request.Request;
import ru.clevertec.request.RequestChainExecutor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.clevertec");
        RequestChainExecutor requestChainExecutor = context.getBean(RequestChainExecutor.class);
        Request request = Request.builder()
                .path("product/update")
                .body(new Product(1L, "some product"))
                .user(User.builder()
                        .login("admin")
                        .password("admin")
                        .build())
                .build();
        requestChainExecutor.execute(request);
    }
}