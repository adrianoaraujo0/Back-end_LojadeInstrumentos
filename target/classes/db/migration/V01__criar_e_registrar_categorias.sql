CREATE TABLE categoria (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categoria (nome) values ('Sopro');
INSERT INTO categoria (nome) values ('Percussão');
INSERT INTO categoria (nome) values ('Eletrônicos');
INSERT INTO categoria (nome) values ('Cordas');