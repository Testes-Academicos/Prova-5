CREATE DATABASE contactos;

USE contactos;

create table if not exists users(
    id int auto_increment primary key,
    username varchar(50) not null,
    senha varchar(150) not null
);

create table if not exists perfil(
    id int auto_increment primary key,
    nome varchar(50) not null
);

create table if not exists users_perfil(
    users_id int,
    perfil_id int
);


create table if not exists contactos(
    id int auto_increment primary key,
    nome varchar(255),
    email varchar(255),
    telefone varchar(255),
    CONSTRAINT contactos_unique UNIQUE (id)
);

 insert into contactos(nome,email,telefone)
 values
 ('LIO CROONS','liocroons@prova.com','459033369'),
 ('Professor','lucas@prova','55566');