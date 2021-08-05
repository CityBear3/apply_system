CREATE TABLE request (
    id int NOT NULL AUTO_INCREMENT,
    userid varchar(16) NOT NULL,
    product varchar(256) NOT NULL,
    propose varchar(32) NOT NULL,
    reason varchar(256) NOT NULL,
    PRIMARY KEY(id)
);