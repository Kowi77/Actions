Инструкция по установке:

1) Context path приложения "/", после деплоя через Tomcat оно доступно по адресу http://localhost:8080/action/
2) Перед запуском должна быть создана и подключена БД (url=jdbc:postgresql://localhost:5432/action, user=user, password=password, driver=org.postgresql.Driver)

Используемые технологии:

1) DB: Postgre + Hibernate + Spring Data
2) Back-end: Spring web + webMVC с конфигурацией через аннотации в Java классах
3) Front-end: JSP + JSTL + Bootstrap

Исходный код приложения доступен на https://github.com/Kowi77/Actions

