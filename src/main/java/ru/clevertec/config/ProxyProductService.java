package ru.clevertec.config;

import lombok.extern.slf4j.Slf4j;
import ru.clevertec.model.Product;
import ru.clevertec.service.ProductService;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class ProxyProductService implements ProductService {
    private final ProductService productService;
    private final String className;

    public ProxyProductService(ProductService productService) {
        this.productService = productService;
        this.className = productService.getClass().getName();
    }

    @Override
    public void update(Product product) {
        Method currentMethod = new Object() {
        }.getClass().getEnclosingMethod();
        Method realMethod = getRealMethod(currentMethod);
        boolean hasLogAnnotation = hasLogAnnotation(realMethod);

        if (hasLogAnnotation) {
            log.info(className + " start invoke method " + currentMethod.getName());
        }

        productService.update(product);

        if (hasLogAnnotation) {
            log.info(className + " end invoke method " + currentMethod.getName());
        }
    }


    private boolean hasLogAnnotation(Method method) {
        return Arrays.stream(method.getDeclaredAnnotations())
                .peek(annotation -> System.out.println(annotation.annotationType()))
                .anyMatch(annotation -> annotation.annotationType() == Log.class);
    }

    private Method getRealMethod(Method currentMethod) {
        try {
            String name = currentMethod.getName();
            Class<?>[] parameterTypes = currentMethod.getParameterTypes();
            return productService.getClass().getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
