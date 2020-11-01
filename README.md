## I
* __Название дисциплины:__ Технологии разработки программного обеспечения
* __Название лабораторной работы:__ Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных
* __ФИО и группа:__ Бадулин А.С. ЗМБД2031
* __Цель лабораторной работы:__ Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов)

## II
#### Для работы требуется
* Docker 18 или выше
* docker-compose 1.24 или выше
* curl
* Свободный 80-порт
#### Инструкция по сборке запуску приложения
* Склонировать репозиторий
* Для сборки, запуска приложения и его окружения необходимо из директории с кодовой базой выполнить команду __docker-compose up -d__
* Сборка приложения выполняется в отдельном контейнере, затем создается образ с ojdk8 в который копируется артефакт (процедура сборки и копирования описана в Dockerfile)
#### Проверки

------------------------------------------------------------------------
__Status__
* __getHostname:__ curl http://localhost/api/v1/status
------------------------------------------------------------------------
__CRUD__
* __create:__ curl -v -H  "Content-Type: application/json" -X POST http://localhost/api/v1/invention -d '{"name": "Гравицапа", "inventor": "Неизвестен", "year": "нет данных", "app_area": "мгновенные межгалактические перелёты" }'
* __read:__ curl http://localhost/api/v1/invention/{id} (id от 1 до 7)
* __update:__ curl -v -H  "Content-Type: application/json" -X POST http://localhost/api/v1/invention -d '{"id": __{id}__, "name": "Гиперболоид", "inventor": "Гарин Пётр Петрович", "year": "~1920", "app_area": "завоевание мирового господства" }' (id от 1 до 7)
* __delete:__ curl -X DELETE http://localhost/api/v1/invention/{id} (id от 1 до 7)
* __readAll:__ curl http://localhost/api/v1/invention

-----------------------------------------------------------------------
* __Лабораторная работа №3: CI/CD и деплой приложения в Heroku__
* __Целью лабораторной работы является знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.__
* http://simpleapi-badulin.herokuapp.com/api/v1/status
* [![Build Status](https://travis-ci.com/Natrofl/trpo_lab1.svg?branch=main)](https://travis-ci.com/Natrofl/trpo_lab1)
