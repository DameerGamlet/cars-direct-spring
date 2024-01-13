# CARs DIRECT

Приложение Car Direct предоставляет следующие возможности:

- Поиск автомобилей по параметрам
- Сравнение автомобилей
- Оформление сделки купли-продажи

## Технологии

Backend: 
- Spring Boot (Data, Security, ...), Java 17, Postgresql 15, docker, Kafka, Redis, JWT, ...

~~Frontend: React, TS, HTML, CSS, Webpack~~

## Превью

![img.png](resources/images/tree.png)

### Создание нового пользователя через user-service (по api-gateway-service)

![create_new_user.png](resources%2Fimages%2Fcreate_new_user.png)

На данном этапе создаётся запись в БД для данного пользователя, а также токен для активации.

Пользователь может работать с пользовательской системы только после этапа акцивации пользователя.

## Активация через mail-service (по api-gateway-service, связь с user-service c WebClient класса)

![activate_user.png](resources%2Fimages%2Factivate_user.png)
![user_activate.png](resources%2Fimages%2Fuser_activate.png)

## Созданные пользователи (через Postgres из Docker Container)

![created_users.png](resources%2Fimages%2Fcreated_users.png)

## Получение токена пользователя (для работы с пользователем) - authorization-service

![create_token.png](resources%2Fimages%2Fcreate_token.png)

Позволяет создавать токен, который пригодится для всех операций, которые должны быть доступны только для авторизованного
пользователя или пользователя с определённым статусом.

Например, выставить на продажу автомобиль может только пользователь с ролью SELLER.

## Получение статуса продавца (связь через Kafka MQ между user-service и seller-service)

![created_seller_by_user.png](resources%2Fimages%2Fcreated_seller_by_user.png)

### Отправка

![kafka-produce.png](resources%2Fimages%2Fkafka-produce.png)

### Принятие

![kafka-consume.png](resources%2Fimages%2Fkafka-consume.png)

## Асинхронное взаимодействие с использованием реактивного программиварония

![auth.png](resources%2Fimages%2Fauth.png)
![mail.png](resources%2Fimages%2Fmail.png)

## Docker

![jib.png](resources%2Fimages%2Fjib.png)
![docker.png](resources%2Fimages%2Fdocker.png)

## Создание автомобиля

![create_car.png](resources%2Fimages%2Fcreate_car.png)

## SWAGGER

![img.png](resources/images/swaggerui.png)
![img.png](resources/images/swagger.png)

## Описание

- ✅ 1. Написать монолит с 5-10 доменными сущностями (интернет магазин, CRM система, или т.п.), желательно придерживаться Clean Architecture. (yes)
- ✅ 2. Попилить на микросервисы 
- ✅ 3. Обернуть в докер контейнеры (jib)
- ✅ 4. Реализовать пример оркестрации или хореографии (docker + k8s)
- ✅ Реализовать пример асинхронного взаимодействия между сервисами
- ✅ 6. Подключить шину данных (Rabbit MQ)
- ✅ 7. Авторизация и аутентификация через единый микросервис авторизации (api-gateway-service)
