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