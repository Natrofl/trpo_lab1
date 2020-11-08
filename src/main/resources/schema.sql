drop table if exists inventions cascade;
drop sequence if exists inventions_seq;

create sequence inventions_seq start with 1;

create table inventions(
                           id          integer primary key default nextval('inventions_seq'),
                           name        varchar         not null,
                           inventor    varchar         not null,
                           year        varchar         not null
);

drop table if exists areas cascade;
drop sequence if exists areas_seq;

create sequence areas_seq start with 1;

create table areas(
                      id          integer primary key default nextval('areas_seq'),
                      area        varchar         not null,
                      inv_id      int         not null
);