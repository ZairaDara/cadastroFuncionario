package com.pagamentos.cadastrofuncionario.service;

import com.pagamentos.cadastrofuncionario.entity.Cargo;

import java.util.Optional;

public interface CargoService {


    Cargo save(Cargo cargo);

    Optional<Cargo> findById(Long idCargo);

    //não criei o delete para não correr o risco de deletar cargos associados a funcionarios.
    //void delete(Long idCargo);


}
