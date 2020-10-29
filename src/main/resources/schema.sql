drop table if exists invention cascade;
drop sequence if exists global_seq;

create sequence global_seq start with 1;

create table invention(
    id          integer primary key default nextval('global_seq'),
    inventor    varchar         not null

);

drop table if exists inno cascade;
drop sequence if exists inno_seq;

create sequence inno_seq start with 1;

create table inno(
    id          integer primary key default nextval('inno_seq'),
    name        varchar         not null,
    year        varchar         not null,
    app_area    varchar         not null,
    inventor_id integer         not null
);
