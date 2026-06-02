package org.example.Model;
import java.time.LocalDate;

public class VendaModel {
    public int id;
    public String descricao;
    public LocalDate dataVenda;
    public String nomeProduto;
    public Double valorProduto;
    public int quantidade;
    public double valorTotalVenda;
    public int idFuncionario;

    public VendaModel(int id, String descricao, LocalDate dataVenda, String nomeProduto,
                      Double valorProduto, int quantidade, int idFuncionario){
        this.id = id;
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
        this.valorTotalVenda = valorProduto * quantidade;
        this.idFuncionario = idFuncionario;
    }
}
