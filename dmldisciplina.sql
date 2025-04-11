SELECT * FROM datatechapi.disciplina;

insert into disciplina(nome,cursoid,professorid) values
('Linguagem de Programação I',2,1),
('Engenharia de Software',2,3),
('Arquitetura e Modelagem de Banco de Dados',2,2),
('Fundamentos de Gestão de Pessoas',2,6),
('Inglês II',2,7),
('Fundamentos de Cálculo',2,4),
('Planejamnto Estratégico',2,5),
('Laboratório de Desenvolvimento em BD II',2,1);

update disciplina set nome = 'Planejamento Estratégico'
where id= 7;