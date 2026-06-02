package org.example.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class FuncionarioRequestDTO {
    public String Nome;
    public String Telefone;
    public String Email;
    public String Endereco;
    public String Cidade;
    public Double Salario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate DataNascimento;
}
