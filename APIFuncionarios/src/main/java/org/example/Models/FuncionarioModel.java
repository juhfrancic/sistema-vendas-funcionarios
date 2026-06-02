package org.example.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Funcionario")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFuncionario")
    public int IdFuncionario;
    public String Nome;
    public String Telefone;
    public String Email;
    public String Endereco;
    public String Cidade;
    public Double Salario;

    @Column(name = "DataNasc")
    public LocalDate DataNascimento;

    @Column(name = "DataCadas")
    public LocalDate DataCadastro;

    public FuncionarioModel(int IdFuncionario, String Nome, String Telefone,
                            String Email, String Endereco, String Cidade,
                            Double Salario, LocalDate DataNascimento, LocalDate DataCadastro){
        this.IdFuncionario = IdFuncionario;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Endereco = Endereco;
        this.Cidade = Cidade;
        this.Salario = Salario;
        this.DataNascimento = DataNascimento;
        this.DataCadastro = DataCadastro;
    }

    public FuncionarioModel() {
    }
}
