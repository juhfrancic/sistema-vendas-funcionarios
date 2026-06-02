CREATE DATABASE VendasDataBase;
USE VendasDataBase;

CREATE TABLE Venda (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Descricao VARCHAR(255) NOT NULL,
    DataVenda DATE NOT NULL,
    NomeProduto VARCHAR(255) NOT NULL,
    ValorProduto DECIMAL(10,2) NOT NULL,
    Quantidade INT NOT NULL,
    ValorTotalVenda DECIMAL(10,2) NOT NULL,
    IdFuncionario INT NOT NULL
);
DROP TABLE Venda;

SELECT * FROM Venda;
SELECT 
    v.id,
    v.descricao,
    v.dataVenda,
    v.nomeProduto,
    v.valorProduto,
    v.quantidade,
    v.valorTotalVenda,
    v.idFuncionario
FROM Venda v