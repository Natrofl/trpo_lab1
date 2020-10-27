## I
* __Название дисциплины:__ Технологии разработки программного обеспечения
* __Название лабораторной работы:__ Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных
* __ФИО и группа:__ Бадулин А.С. ЗМБД2001
* __Цель лабораторной работы:__ Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов)

## II
#### Для работы требуется
* Docker 18 или выше
* docker-compose 1.24 или выше
* Свободный 80-порт
#### Инструкция по сборке запуску приложения
* Склонировать репозиторий
* Для сборки, запуска приложения и его окружения необходимо из директории с кодовой базой выполнить команду __docker-compose up -d__
* Сборка приложения выполняется в отдельном контейнере, затем создается образ с ojdk8 в который копируется артефакт (процедура сборки и копирования описана в Dockerfile)
* __getHostname:__ curl http://localhost/api/v1/status
------------------------------------------------------------------------
* __create:__ curl -v -H  "Content-Type: application/json" -X POST http://localhost/api/v1/invention -d '{"name": "Гравицапа", "inventor": "Неизвестен", "year": "нет данных", "app_area": "мгновенные межгалактические перелёты" }'
* __update:__ curl -v -H  "Content-Type: application/json" -X POST http://localhost/api/v1/invention -d '{"id": __{id}__, "name": "Гиперболоид", "inventor": "Гарин Пётр Петрович", "year": "~1920", "app_area": "завоевание мирового господства" }' (id от 1 до 7)
* __delete:__ curl -X DELETE http://localhost/api/v1/invention/__{id}__ (id от 1 до 7)
* __read:__ curl http://localhost/api/v1/invention/__{id}__ (id от 1 до 7)
* __readAll:__ curl http://localhost/api/v1/invention
