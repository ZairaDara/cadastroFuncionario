package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.CargoPostDto;
import com.pagamentos.cadastrofuncionario.dto.CargoSaveRequestDTO;
import com.pagamentos.cadastrofuncionario.dto.CargoSaveResponseDTO;
import com.pagamentos.cadastrofuncionario.entity.Cargo;
import com.pagamentos.cadastrofuncionario.service.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<CargoSaveResponseDTO> save (@RequestBody CargoSaveRequestDTO  cargoRequest){

        Cargo cargo = new Cargo();
        cargo.setDescricaoCargo(cargoRequest.getDescricaoCargo());
        cargo.setSalarioBase(cargoRequest.getSalarioBase());

        cargoService.save(cargo);

        CargoSaveResponseDTO cargoResponse = new CargoSaveResponseDTO();
        cargoResponse.setIdCargo(cargo.getIdCargo());
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoResponse);


        //return ResponseEntity.ok().build();
    }
}

