create database Datatechapi;

use datatechapi;
create user 'datatech'@'localhost' identified by 'admin123'; 

grant select,insert, update,delete  on datatechapi.* to datatech@'localhost';

create table curso
(id int primary key auto_increment,
nome varchar(100) not null unique,
siglacurso varchar(30) not null unique);

create table disciplina
(id int primary key auto_increment,
nome varchar(100) not null,
cursoid int not null,
professorid int not null);

create table professor
(id int primary key auto_increment,
nome varchar(100) not null,
email varchar(100) not null unique,
senha  varchar(2000) not null);

alter table disciplina
add foreign key(cursoid)
references curso(id);

alter table disciplina
add foreign key(professorid)
references professor(id);

