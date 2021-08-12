create database lavajato;
use lavajato;

create table tipocarro(
 codigo int(7) auto_increment,
 tipo varchar(30),
 descricao varchar(100),
 preconormal float(10,2),
 precocompleta float(10,2),
 primary key(codigo)
);

create table carro(
 placa varchar(10),
 marca varchar(20),
 corpredominante varchar(15),
 nomedono varchar(40),
 contatodono varchar(30),
 cod_tipocarro int(7),
 primary key(placa),
 constraint fk_carroTipoCarro foreign key(cod_tipoCarro) references tipocarro(codigo)
);

create table lavagem(
 codigo int(7) auto_increment,
 dataEHoraEntrega datetime,
 dataEHoraTermino datetime,
 pronto boolean,
 pago boolean,
 tipolavagem varchar(15),
 valor float(10,2),
 placa_carro varchar(10),
 primary key(codigo),
 constraint fk_lavagemCarro foreign key(placa_carro) references carro(placa)
);
