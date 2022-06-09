---------------------------------
------------- GRUPO -------------
---------------------------------
-- Luan F Barcelos
-- Marcos Paulo Rios da Silva
-- Nikolly Cardoso de Faria

--------------------------------

CREATE SCHEMA IF NOT EXISTS public AUTHORIZATION restaurante;

CREATE TABLE public.categorias (
	codigo int4 NOT NULL,
	descricao varchar(100) NOT NULL,
	CONSTRAINT categorias_pk PRIMARY KEY (codigo)
);

CREATE TABLE public.empregados (
	codigo int4 NOT NULL,
	nome varchar(100) NOT NULL,
	data_contrato date NOT NULL,
	rg varchar(100) NOT NULL,
	CONSTRAINT empregados_pk PRIMARY KEY (codigo)
);

CREATE TABLE public.ingredientes (
	nome varchar(100) NOT NULL,
	descricao varchar(200) NULL,
	CONSTRAINT ingredientes_pk PRIMARY KEY (nome)
);

CREATE TABLE public.restaurantes (
	codigo int4 NOT NULL,
	nome varchar(100) NOT NULL,
	CONSTRAINT restaurantes_pk PRIMARY KEY (codigo)
);

CREATE TABLE public.cozinheiros (
	cod_empregado int4 NOT NULL,
	fantasia varchar(100) NULL,
	CONSTRAINT cozinheiros_pk PRIMARY KEY (cod_empregado),
	CONSTRAINT cozinheiros_un UNIQUE (fantasia),
	CONSTRAINT cozinheiros_fk FOREIGN KEY (cod_empregado) REFERENCES public.empregados(codigo)
);

CREATE TABLE public.cozinheiros_restaurantes (
	cozinheiro int4 NOT NULL,
	restaurante int4 NOT NULL,
	CONSTRAINT cozinheiro_restaurante_pk PRIMARY KEY (cozinheiro, restaurante),
	CONSTRAINT cozinheiro_restaurante_fk FOREIGN KEY (cozinheiro) REFERENCES public.cozinheiros(cod_empregado),
	CONSTRAINT cozinheiro_restaurante_fk_1 FOREIGN KEY (restaurante) REFERENCES public.restaurantes(codigo)
);

CREATE TABLE public.degustadores (
	cod_empregado int4 NOT NULL,
	CONSTRAINT degustadores_pk PRIMARY KEY (cod_empregado),
	CONSTRAINT degustadores_fk FOREIGN KEY (cod_empregado) REFERENCES public.empregados(codigo)
);

CREATE TABLE public.editores (
	cod_empregado int4 NOT NULL,
	CONSTRAINT editores_pk PRIMARY KEY (cod_empregado),
	CONSTRAINT editores_fk FOREIGN KEY (cod_empregado) REFERENCES public.empregados(codigo)
);

CREATE TABLE public.livros (
	titulo varchar(100) NOT NULL,
	isbn varchar(100) NOT NULL,
	editor int4 NOT NULL,
	CONSTRAINT livros_pk PRIMARY KEY (titulo),
	CONSTRAINT livros_un UNIQUE (isbn),
	CONSTRAINT livros_fk FOREIGN KEY (editor) REFERENCES public.editores(cod_empregado)
);

CREATE TABLE public.receitas (
	codigo int4 NOT NULL,
	nome varchar(100) NOT NULL,
	data_criacao date NOT NULL,
	cozinheiro int4 NOT NULL,
	categoria int4 NOT NULL,
	CONSTRAINT receitas_pk PRIMARY KEY (codigo),
	CONSTRAINT receitas_un UNIQUE (nome, cozinheiro),
	CONSTRAINT receitas_fk FOREIGN KEY (cozinheiro) REFERENCES public.cozinheiros(cod_empregado),
	CONSTRAINT receitas_fk_1 FOREIGN KEY (categoria) REFERENCES public.categorias(codigo)
);

CREATE TABLE public.receitas_livros (
	receita int4 NOT NULL,
	livro varchar(100) NOT NULL,
	CONSTRAINT receitas_livro_pk PRIMARY KEY (receita, livro),
	CONSTRAINT receitas_livro_fk FOREIGN KEY (receita) REFERENCES public.receitas(codigo),
	CONSTRAINT receitas_livro_fk_1 FOREIGN KEY (livro) REFERENCES public.livros(titulo)
);

CREATE TABLE public.degustadores_receitas (
	degustador int4 NOT NULL,
	receita int4 NOT NULL,
	data_degustacao date NOT NULL,
	nota numeric(2, 2) NOT NULL,
	CONSTRAINT degustador_receita_pk PRIMARY KEY (degustador, receita),
	CONSTRAINT degustador_receita_fk FOREIGN KEY (degustador) REFERENCES public.degustadores(cod_empregado),
	CONSTRAINT degustador_receita_fk_1 FOREIGN KEY (receita) REFERENCES public.receitas(codigo)
);

CREATE TABLE public.ingredientes_receitas (
	receita int4 NOT NULL,
	cozinheiro int4 NOT NULL,
	ingrediente varchar(100) NOT NULL,
	quantidade numeric(5, 2) NULL,
	medida varchar(100) NOT NULL,
	descricao text NULL,
	rendimento int4 NOT NULL,
	CONSTRAINT ingredientes_receitas_pk PRIMARY KEY (receita, cozinheiro, ingrediente),
	CONSTRAINT ingredientes_receitas_fk FOREIGN KEY (receita) REFERENCES public.receitas(codigo),
	CONSTRAINT ingredientes_receitas_fk_1 FOREIGN KEY (cozinheiro) REFERENCES public.cozinheiros(cod_empregado),
	CONSTRAINT ingredientes_receitas_fk_2 FOREIGN KEY (ingrediente) REFERENCES public.ingredientes(nome)
);

