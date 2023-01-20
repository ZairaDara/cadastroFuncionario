package com.pagamentos.cadastrofuncionario.service.impl;

import com.pagamentos.cadastrofuncionario.entity.Cargo;
import com.pagamentos.cadastrofuncionario.repository.CargoRepository;
import com.pagamentos.cadastrofuncionario.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    private CargoRepository cargoRepository;

    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long idCargo) {
        return cargoRepository.findById(idCargo);
    }

}
