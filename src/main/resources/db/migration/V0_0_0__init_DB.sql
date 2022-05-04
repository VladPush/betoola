create table client_money_purse
(
    id          bigserial primary key,
    money_value decimal(12, 2) not null default 0 check (money_value >= 0)
);


create table exchange_rate
(
    id          bigserial primary key,
    numerator   varchar        not null,
    denominator varchar        not null,
    rate        decimal(10, 2) not null check (rate != 0),
    unique (numerator, denominator)
);