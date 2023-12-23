# CARs DIRECT

Описание

## Технологии

Backend: 
- Spring Boot (Data, Security, ...), 
- Java 17, 
- Postgresql 15, 
- docker, 
- Kafka, 
- Redis, 
- kubernates, ...

Frontend: 
- React, 
- TS, 
- HTML, 
- CSS, 
- Webpack

## Превью

### Создание нового пользователя через user-service (по api-gateway-service)

![create_new_user.png](resources%2Fimages%2Fcreate_new_user.png)

## Активация через mail-service (по api-gateway-service, связь с user-service c WebClient класса)

![user_activate.png](resources%2Fimages%2Fuser_activate.png)

## Созданные пользователи (через Postgres из Docker Container)

![created_users.png](resources%2Fimages%2Fcreated_users.png)

## Получение токена пользователя (для работы с пользователем)



## Получение статуса в качестве продавка (связь через )

## Инструкция по использованию

TODO: прописать про доступ к работе данного приложения с помощью docker run ...

## Описание

1. Написать монолит с 5-10 доменными сущностями (интернет магазин, CRM система, или т.п.), желательно придерживаться Clean Architecture. (yes)
2. Попилить на микросервисы
3. Обернуть в докер контейнеры (jib)
4. Реализовать пример оркестрации или хореографии (docker + k8s)
5. Реализовать пример асинхронного взаимодействия между сервисами
6. Подключить шину данных (Rabbit MQ)
7. Авторизация и аутентификация через единый микросервис авторизации (api-gateway-service)
