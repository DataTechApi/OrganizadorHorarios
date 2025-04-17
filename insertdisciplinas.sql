select *from professor;

insert into professor (nome,email,senha,ehCoordenador) values
('Fabinao Sabha','sabah@fatec','123',1),
('Leonidas Lopes','leonidas@fatec','123',0),
('Maria Goreti','goretei@fatec','123',0),
('Marcos Allan','marcos@fatec','123',0);

insert into disciplina (nome,cursoid,professorid) values
('Algoritmos',1,8),
('Fundamentos de Administração',1,5),
('Arquitetura e Organização de Computadores',1,9),
('Comunicação e Expressão',1,10),
('Inglês I',1,7),
('Laboratório de Desenvolvimento BD I',1,9),
('Matemática Discreta',1,11);