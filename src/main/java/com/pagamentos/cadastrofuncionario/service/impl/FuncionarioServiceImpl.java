package com.pagamentos.cadastrofuncionario.service.impl;

import com.pagamentos.cadastrofuncionario.entity.Funcionario;
import com.pagamentos.cadastrofuncionario.repository.FuncionarioRepository;
import com.pagamentos.cadastrofuncionario.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

    @Override
    public void delete(Long idFuncionario) {
    }

}
