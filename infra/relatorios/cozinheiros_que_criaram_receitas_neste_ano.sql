SELECT DISTINCT e.nome,
       c.fantasia,
       COUNT(r.codigo) AS qtd_receitas
FROM receitas r
INNER JOIN cozinheiros c ON r.cozinheiro = c.cod_empregado
INNER JOIN empregados e ON c.cod_empregado = e.codigo
WHERE date_part('year', r.data_criacao) = date_part('year', now())
GROUP BY 1,2
HAVING COUNT(r.codigo) >= 2;