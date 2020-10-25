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