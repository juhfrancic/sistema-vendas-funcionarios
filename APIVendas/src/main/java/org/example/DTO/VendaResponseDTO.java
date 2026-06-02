package org.example.DTO;

import org.example.Model.VendaModel;

import java.time.LocalDate;

public class VendaResponseDTO {
    public int id;
    public String descricao;
    public LocalDate dataVenda;
    public String nomeProduto;
    public Double valorProduto;
    public int quantidade;
    public double valorTotalVenda;
    public FuncionarioResponseDTO funcionario;

    public VendaResponseDTO(VendaModel venda, FuncionarioResponseDTO funcionario) {
        this.id = venda.id;
        this.descricao = venda.descricao;
        this.dataVenda = venda.dataVenda;
        this.nomeProduto = venda.nomeProduto;
        this.valorProduto = venda.valorProduto;
        this.quantidade = venda.quantidade;
        this.valorTotalVenda = venda.valorTotalVenda;
        this.funcionario = funcionario;
    }
}
