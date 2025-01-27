CREATE TABLE menu (
    id varchar(36),
    menu_name VARCHAR(50) NOT NULL,
    menu_description VARCHAR(255) NOT NULL,
    price int NOT NULL
);

CREATE TABLE orders (
    id varchar(36),
    customer_name VARCHAR(50) NOT NULL,
    menu_id VARCHAR(255) NOT NULL
);

CREATE TABLE members (
    id varchar(36),
    full_name varchar(255) not null,
    email varchar(50) not null,
    phone varchar(50) not null,
    password varchar(50) not null,
    primary key (id),
    unique (email)
);

