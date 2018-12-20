
CREATE DATABASE  IF NOT EXISTS  antoiovi_tutorials DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
DROP  TABLE IF  EXISTS persone;
CREATE TABLE IF NOT EXISTS persone (
    persona_id INT AUTO_INCREMENT,
    username VARCHAR(10) NOT NULL,
    nome VARCHAR(10) NOT NULL,
    cognome VARCHAR(10) NOT NULL,
    email VARCHAR(40) ,
    password VARCHAR(256) ,
    UNIQUE (username),
    PRIMARY KEY (persona_id)
)  ENGINE=INNODB;
