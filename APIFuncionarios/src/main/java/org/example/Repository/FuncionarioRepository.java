package org.example.Repository;

import org.example.Models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository
        extends JpaRepository<FuncionarioModel, Integer> {
}

