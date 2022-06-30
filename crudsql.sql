create database crudLivraria;
use crudLivraria;

create table livro
(
codigo varchar(5) not null,
nome varchar(100) not null,
autor varchar(100) not null,
genero varchar(50) not null,
qtdPagina varchar(5) not null,
preco varchar(10) not null,
primary key(codigo)
);
