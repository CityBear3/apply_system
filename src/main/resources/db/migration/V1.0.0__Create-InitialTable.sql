CREATE TABLE users (
    id varchar(16) NOT NULL UNIQUE,
    name varchar(64) NOT NULL,
    password varchar(256) NOT NULL,
    PRIMARY KEY(id)
)

CREATE TABLE books (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(256) NOT NULL,
    isbn varchar(14) NOT NULL,
    PRIMARY KEY(id)
)

INSERT INTO books(title, isbn) VALUES ('Web API: The Good Parts', '978-4873116860')