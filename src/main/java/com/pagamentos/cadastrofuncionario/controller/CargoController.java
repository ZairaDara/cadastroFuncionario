package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.CargoPostDto;
import com.pagamentos.cadastrofuncionario.dto.CargoResponseDTO;
import com.pagamentos.cadastrofuncionario.dto.CargoSaveRequestDTO;
import com.pagamentos.cadastrofuncionario.dto.CargoSaveResponseDTO;
import com.pagamentos.cadastrofuncionario.entity.Cargo;
import com.pagamentos.cadastrofuncionario.service.CargoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<CargoSaveResponseDTO> save (@RequestBody @Valid CargoSaveRequestDTO  cargoRequest){

        Cargo cargo = new Cargo();
        cargo.setDescricaoCargo(cargoRequest.getDescricaoCargo());
        cargo.setSalarioBase(cargoRequest.getSalarioBase());

        cargoService.save(cargo);

        CargoSaveResponseDTO cargoResponse = new CargoSaveResponseDTO();
        cargoResponse.setIdCargo(cargo.getIdCargo());
        cargoResponse.setMessage("Cargo incluído com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoResponse);
    }

    @GetMapping("/{idCargo}")
    public ResponseEntity<CargoResponseDTO> consultarCargo (@PathVariable Long idCargo) {


        Optional<Cargo> cargoOptional = cargoService.findById(idCargo);
        if (cargoOptional.isEmpty()) return ResponseEntity.notFound().build();

        Cargo cargo = cargoOptional.get();

        CargoResponseDTO cargoResponse = new CargoResponseDTO();
        cargoResponse.setDescricaoCargo(cargo.getDescricaoCargo());
        cargoResponse.setIdCargo(cargo.getIdCargo());
        cargoResponse.setSalarioBase(cargo.getSalarioBase());

        return ResponseEntity.status(HttpStatus.OK).body(cargoResponse);
    }


    @PutMapping("/{idCargo}")
    public ResponseEntity<CargoSaveResponseDTO> editarCargo (@PathVariable Long idCargo, @RequestBody @Valid CargoSaveRequestDTO  cargoRequest){

        Optional<Cargo> cargoOptional = cargoService.findById(idCargo);
        if (cargoOptional.isEmpty()) return ResponseEntity.notFound().build();

        Cargo cargo = cargoOptional.get();

        cargo.setDescricaoCargo(cargoRequest.getDescricaoCargo());
        cargo.setSalarioBase(cargoRequest.getSalarioBase());

        cargoService.save(cargo);

        CargoSaveResponseDTO cargoResponse = new CargoSaveResponseDTO();
        cargoResponse.setIdCargo(cargo.getIdCargo());
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoResponse);
    }

}

