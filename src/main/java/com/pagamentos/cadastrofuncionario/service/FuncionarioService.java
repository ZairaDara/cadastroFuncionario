package com.pagamentos.cadastrofuncionario.service;

import com.pagamentos.cadastrofuncionario.entity.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    Funcionario save(Funcionario funcionario);

    Optional<Funcionario> findById(Long idFuncionario);

    void delete(Long idFuncionario);

}
