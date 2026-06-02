CREATE DATABASE FuncionariosDataBase;
USE FuncionariosDataBase;

CREATE TABLE Funcionario (
    IdFuncionario INT IDENTITY(1,1) PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL,
    Telefone VARCHAR(20) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Endereco VARCHAR(100) NOT NULL,
    Cidade VARCHAR(50) NOT NULL,
    Salario DECIMAL(10,2) NOT NULL,
    DataNasc DATE NOT NULL,
    DataCadas DATE NOT NULL
);

SELECT * FROM Funcionario;