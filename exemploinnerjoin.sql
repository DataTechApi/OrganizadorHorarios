select d.nome, p.nome from disciplina as d
inner join professor as p on d.professorid = p.id ;