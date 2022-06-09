SELECT --DISTINCT
    r.codigo AS cod_receita,
    r.nome AS nome_receita,
    r.data_criacao,
    co.fantasia AS fantasia_cheff,
    e.nome AS nome_cheff,
    ca.descricao AS descricao_categoria
FROM ingredientes_receitas ir
INNER JOIN receitas r ON ir.receita = r.codigo
LEFT JOIN categorias ca ON r.categoria = ca.codigo
LEFT JOIN cozinheiros co ON r.cozinheiro = co.cod_empregado
INNER JOIN empregados e ON co.cod_empregado = e.codigo
ORDER BY 1