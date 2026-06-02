package org.example.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import org.example.DTOs.FuncionarioRequestDTO;
import org.example.Models.FuncionarioModel;
import org.example.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public void CadastrarFuncionario(FuncionarioRequestDTO funcionario) {
        if (funcionario.Nome == null)
            throw new IllegalArgumentException("Nome obrigatório");


        FuncionarioModel novoFuncionario = new FuncionarioModel(
                0,
                funcionario.Nome,
                funcionario.Telefone,
                funcionario.Email,
                funcionario.Endereco,
                funcionario.Cidade,
                funcionario.Salario,
                funcionario.DataNascimento,
                LocalDate.now()
        );

        repository.save(novoFuncionario);
    }

    public FuncionarioModel BuscarFuncionario(int id) {
        return repository.findById(id).orElse(null);
    }
}
