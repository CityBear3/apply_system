CREATE TABLE users (
    id varchar(16) NOT NULL UNIQUE,
    name varchar(64) NOT NULL,
    password varchar(256) NOT NULL,
    role varchar(6) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE books (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(256) NOT NULL,
    isbn varchar(14) NOT NULL,
    PRIMARY KEY(id)
);
