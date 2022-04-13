CREATE TABLE produto (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	quantidade INTEGER NOT NULL,
	preco_custo DECIMAL(10,2) NOT NULL,
	preco_venda DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(500),
	codigo_categoria BIGINT NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;



INSERT INTO produto (nome, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('Guitarra', 10, 500, 870, 'Mais de 50 anos de idade.', 3);
INSERT INTO produto (nome, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('Gaita', 100, 50, 70, 'Otima qualidade e novo.', 1);
INSERT INTO produto (nome, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('Carron', 10, 100, 170, 'Otima qualidade e novo.', 2);
INSERT INTO produto (nome, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) values ('Harpa', 10, 200, 370, 'Otima qualidade e novo.', 4);
