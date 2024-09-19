package ru.clevertec.request.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.clevertec.controller.ProductController;
import ru.clevertec.model.Product;
import ru.clevertec.request.Request;

@Component
@RequiredArgsConstructor
public class UpdateProduct implements RequestCommand {
    private final ProductController productController;

    @Override
    public void execute(Request request) {
        Product product = (Product) request.getBody();
        productController.update(product);
    }

    @Override
    public String getPath() {
        return "product/update";
    }
}
