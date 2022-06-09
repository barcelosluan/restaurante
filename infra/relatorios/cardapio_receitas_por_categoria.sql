SELECT r.codigo,
    r.nome as receita,
    e.nome AS cozinheiro
FROM receitas r
INNER JOIN cozinheiros c ON r.cozinheiro = c.cod_empregado
INNER JOIN empregados e ON c.cod_empregado = e.codigo
WHERE r.categoria = :categoria