-- create table cars
-- (
--     id bigserial not null
--         constraint car_pkey
--             primary key,
--     name varchar(40),
--     created_at timestamp,
--     stock_number             uuid
-- );

INSERT INTO public.cars(id, name, sku, created_at)
VALUES (100, 'Test car', 'af297977-23a5-44c5-a397-67827ea08254', '2024-09-15 09:00:00');