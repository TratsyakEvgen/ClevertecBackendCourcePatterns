package ru.clevertec.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.clevertec.service.ProductService;

@Component
public class ProxyLogProductServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ProductService.class.isAssignableFrom(bean.getClass())) {
            return new ProxyProductService((ProductService) bean);
        }
        return bean;
    }
}
