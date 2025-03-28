CREATE DATABASE IF NOT EXISTS Backoffice;
USE Backoffice;

CREATE TABLE cliente (
    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    primary key(id)
);

CREATE TABLE pedido(
	id bigint not null auto_increment,
	datax date not null,
	total decimal(6, 2),
	cliente_id bigint,
	primary key(id),
	foreign key(cliente_id) references cliente(id)
);

insert into cliente(nome, email) values ('João Victor', 'joaodicu387@gmail.com');
insert into cliente(nome, email) values ('Gabriel', 'gabriel@gmail.com');
insert into cliente(nome, email) values ('Kalina', 'kalina@gmail.com');
insert into pedido(datax, total, cliente_id) values ('2025-03-20', 120.00, 3);
insert into pedido(datax, total, cliente_id) values ('2025-03-27', 59.99, 1);
insert into pedido(datax, total, cliente_id) values ('2025-03-26', 29.99, 2);
insert into pedido(datax, total, cliente_id) values ('2025-03-26', 29.99, 1);
insert into pedido(datax, total, cliente_id) values ('2025-03-25', 19.89, 1);

select c.nome, p.datax, p.total from cliente c inner join pedido p on p.cliente_id=c.id where p.total > 100;