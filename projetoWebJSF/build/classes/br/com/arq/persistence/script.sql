create database BDgenesis;

use BDgenesis;

create table aluno(
	id int primary key auto_increment,
	nome varchar (50),
	disciplina varchar (50),
	nota1 float,
	nota2 float,
	media float,
	situacao varchar (50)  
);

insert into aluno (nome,disciplina,nota1,nota2,media,situacao)
 values ('nadia','java',9,9,9,'aprovada'),
       ('jorge','java',9,10,9.5,'aprovado'),
       ('wallace','java',9,8,8.5,'aprovado'),
       ('barroso','java',9,10,9.5,'aprovado');
       
 select * from aluno;    
 
 show tables;
 
 desc aluno;
 
 show databases;
 
 use bdgenesis;
 
 
 
 
   
       
 







