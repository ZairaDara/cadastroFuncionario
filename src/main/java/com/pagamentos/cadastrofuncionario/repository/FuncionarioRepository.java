package com.pagamentos.cadastrofuncionario.repository;

import com.pagamentos.cadastrofuncionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
