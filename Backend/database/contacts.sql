CREATE DATABASE contactos;

USE contactos;

CREATE TABLE IF NOT EXISTS contactos.users (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    telefone VARCHAR (12) NOT NULL,
    PRIMARY KEY (id)
    
);