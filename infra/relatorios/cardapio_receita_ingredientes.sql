SELECT r.codigo AS receita,
    i.nome AS ingrediente,
    e.nome AS cozinheiro
FROM ingredientes_receitas ir
INNER JOIN ingredientes i ON ir.ingrediente = i.nome
INNER JOIN receitas r ON ir.receita = r.codigo AND r.codigo = :cod_receita
INNER JOIN cozinheiros c ON ir.cozinheiro = c.cod_empregado
INNER JOIN empregados e ON c.cod_empregado = e.codigo
WHERE ir.receita = :cod_receita;