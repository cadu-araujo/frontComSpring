create database produtos;
use produtos;

show tables;

show create table produto;
INSERT INTO `produtos`.`produto` (`descricao`, `disponibilidade`, `nome`, `valor`) VALUES ('produto de limpeza', 'sim', 'Sabão em barra', '8.99');

select * from produto;