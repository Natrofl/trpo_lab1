SET client_encoding = 'UTF8';

drop table if exists invention cascade;
drop sequence if exists global_seq;

create sequence global_seq start with 1;

create table invention(
    id          integer primary key default nextval('global_seq'),
    name        varchar         not null,
    inventor    varchar         not null,
    year        varchar         not null,
    app_area    varchar         not null
);

insert into invention (name, inventor, year, app_area) values ('Колесо', 'Неизвестен', 'нет данных', 'повсеместно');
insert into invention (name, inventor, year, app_area) values ('Компас', 'Неизвестен', '1100-1200', 'мореплавание');
insert into invention (name, inventor, year, app_area) values ('Печатный станок', 'Йоханнес Гутенберг', '1448-1455', 'печатное дело');
insert into invention (name, inventor, year, app_area) values ('Лампочка', 'Томас Алва Эдисон', '1879', 'повсеместно');
insert into invention (name, inventor, year, app_area) values ('Паровой двигатель', 'Джеймс Уатт', '1769', 'устарело');
insert into invention (name, inventor, year, app_area) values ('Телефон', 'Антонио Меуччи', '1860', 'повсеместно');
insert into invention (name, inventor, year, app_area) values ('Компьютер', 'Чарльз Бэббидж, Алан Тьюринг и другие', '1941', 'повсеместно');
