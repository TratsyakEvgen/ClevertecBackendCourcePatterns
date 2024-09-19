# Описание

Приложение обрабатывающие запросы в виде [Request.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Frequest%2FRequest.java). Request содержит информацию о пользователе, путь и тело запроса


1. Запрос проходит через цепочу опработчиков [RequestChainExecutorImpl.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Frequest%2Fimpl%2FRequestChainExecutorImpl.java), которые валидируют запрос, авторизируют пользователя (паттерн цепочка ответственности) 
2. [ValidatorImpl.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fvalidator%2Fimpl%2FValidatorImpl.java) реализован с применением паттрена стратегия
3. Далее запрос попадает в [FrontControllerRequestHandler.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Frequest%2Fimpl%2FFrontControllerRequestHandler.java), где перенаправляется в конкретный метод [ProductController.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fcontroller%2FProductController.java) (паттерн Команда)
4. [ProductServiceImpl.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fservice%2Fimpl%2FProductServiceImpl.java) проксируется в [ProxyProductService.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fconfig%2FProxyProductService.java) по средствам [ProxyLogProductServiceBeanPostProcessor.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fconfig%2FProxyLogProductServiceBeanPostProcessor.java)
5. В [ProductServiceImpl.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fservice%2Fimpl%2FProductServiceImpl.java) происходит сохранение в репу и отправляются уведомления пользователям через смс и email (паттерн Наблюдатель)
6. [EmailNotifierProductObserver.java](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fservice%2Fnotifier%2Fimpl%2FEmailNotifierProductObserver.java) является фасадом


