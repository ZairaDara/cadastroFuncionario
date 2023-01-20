package com.pagamentos.cadastrofuncionario.repository;

import com.pagamentos.cadastrofuncionario.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
