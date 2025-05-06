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
senha  varchar(2000) not null,
ehCoordenador int not null);

alter table disciplina
add foreign key(cursoid)
references curso(id);

alter table disciplina
add foreign key(professorid)
references professor(id);

create table restricao
(id int primary key auto_increment,
dia int not null,
aula int not null,
professoremail varchar(100) not null);

alter table restricao
add foreign key(professoremail)
references professor(email);

create table grade
(cursonome varchar(45) not null,
dia varchar(45) not null,
horario varchar(45) not null,
disciplinanome varchar(45) not null,
professornome varchar(45));

alter table grade
add foreign key(cursonome)
references curso(nome);

alter table grade
add foreign key(disciplinanome)
references disciplina(nome);

alter table grade change
professoremail professorid int;

alter table grade
add foreign key(professorid)
references professor(id);

alter table grade
add primary key(cursonome,dia,horario);

