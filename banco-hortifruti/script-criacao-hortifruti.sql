CREATE DATABASE hortifruti;

USE hortifruti;

CREATE TABLE cliente(
	id_cliente bigint AUTO_INCREMENT NOT NULL,
	tipo char,
	documento varchar(50),
	nome varchar(50),
	telefone varchar(15),
	PRIMARY KEY (id_cliente)
);

CREATE TABLE pedido(
	id_pedido bigint AUTO_INCREMENT NOT NULL, 
	codigo bigint,
	data_hora timestamp,
	id_cliente bigint NOT NULL,
	id_endereco bigint NOT NULL,
	situacao boolean,
	quantidade_total int,
	valor_total float(5,2),
	valor_final float(5,2),
	desconto float (3,2),
	forma_pagamento varchar(20),
	PRIMARY KEY (id_pedido)
);

CREATE TABLE produto(
	id_produto bigint AUTO_INCREMENT NOT NULL,
	codigo bigint,
	nome varchar(30),
	descricao varchar(50),
	unidade_medida varchar(5), 
	valor_unitario float(5,2),
	status boolean,
	imagem varchar (150),
	PRIMARY KEY (id_produto)
);

CREATE TABLE endereco(
	id_endereco bigint AUTO_INCREMENT NOT NULL,
	cep varchar(9),
	cidade varchar(30),
	bairro varchar(30),
	estado varchar(30),
	rua varchar(30),
	complemento varchar (30),
	numero int,
	PRIMARY KEY (id_endereco)
);

CREATE TABLE item_do_pedido(
	id_item_do_pedido bigint AUTO_INCREMENT NOT NULL,
	id_pedido bigint NOT NULL,
	id_produto bigint NOT NULL,
	quantidade int,
	valor_total float(8,2),
	PRIMARY KEY (id_item_do_pedido)
);

ALTER TABLE pedido ADD CONSTRAINT fk_cliente_pedido FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);
ALTER TABLE pedido ADD CONSTRAINT fk_endereco_pedido FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco);

ALTER TABLE item_do_pedido ADD CONSTRAINT fk_pedido_item_do_pedido FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido);
ALTER TABLE item_do_pedido ADD CONSTRAINT fk_produto_item_do_pedido FOREIGN KEY (id_produto) REFERENCES produto (id_produto);


ALTER TABLE endereco RENAME COLUMN cidade TO localidade, RENAME COLUMN estado TO uf, RENAME COLUMN rua TO logradouro;


SELECT * FROM produto p 

