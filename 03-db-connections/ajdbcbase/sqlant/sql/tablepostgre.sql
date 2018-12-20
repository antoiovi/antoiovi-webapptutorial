DROP  TABLE IF  EXISTS antoiovi.tutorials.persone;
CREATE TABLE IF NOT EXISTS tutorials.persone (
    persona_id SERIAL,
    username VARCHAR(10) NOT NULL,
    nome VARCHAR(10) NOT NULL,
    cognome VARCHAR(10) NOT NULL,
    email VARCHAR(40) ,
    password VARCHAR(256) ,
    UNIQUE (username),
    PRIMARY KEY (persona_id)
);
