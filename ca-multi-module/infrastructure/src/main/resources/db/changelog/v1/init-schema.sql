--liquibase formatted sql

--changeset vmaksimov:id1
create table cars
(
    id                   bigserial   not null primary key,
    name                 varchar,
    stock_number         uuid,
    created_at           timestamp DEFAULT current_date
);